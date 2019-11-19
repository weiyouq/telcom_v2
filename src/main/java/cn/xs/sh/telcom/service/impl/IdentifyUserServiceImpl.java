package cn.xs.sh.telcom.service.impl;


import cn.xs.sh.telcom.bean.IdentifyUser;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;
import cn.xs.sh.telcom.core.IdentifyFunction;
import cn.xs.sh.telcom.dao.management.IIdentifyUserDao;
import cn.xs.sh.telcom.dao.management.IUserDao;
import cn.xs.sh.telcom.service.IIdentifyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 黑白名单管理业务逻辑类
 * @author kenny_peng
 * @created 2019/7/17 15:05
 */
@Service
public class IdentifyUserServiceImpl implements IIdentifyUserService {

    private Logger logger = LoggerFactory.getLogger(IdentifyUserServiceImpl.class);
    @Autowired
    private IIdentifyUserDao identifyUserDao;
    @Autowired
    private IUserDao userDao;

    private static Integer MAX_URL_SUM = 0;
    private String[] identifyUrl;
    @Value("${identity.address}")
    public void setIdentifyAddress(String address) {
        identifyUrl = address.split(",");
        MAX_URL_SUM = identifyUrl.length * 10000;
    }
    private int urlSum = 0;
    /** 均衡url */
    private synchronized String getUseUrl() {
        if (urlSum > MAX_URL_SUM) {
            urlSum = 0;
        }
        return identifyUrl[urlSum++ % identifyUrl.length];
    }
    @Override
    public List<IdentifyUser> selectAll(IdentifyUser identifyUser) {

        List<IdentifyUser> rollLists = identifyUserDao.selectAll(identifyUser);
        return rollLists;
    }

    @Override
    public IdentifyUser selectByPrimaryKey(Long rollListId) {
        IdentifyUser identifyUser = identifyUserDao.selectByPrimaryKey(rollListId);
        return identifyUser;
    }

    @Override
    public ResponseBase deleteByIds(String rollListIds) {
        try {
            List<String> listIds = new ArrayList<>(Arrays.asList(rollListIds.split(",")));
            int i = identifyUserDao.deleteByIds(listIds);
            if(i>0){
                return ResponseBase.ok("删除用户成功！");
            }
            logger.info("受影响行数为0，删除用户失败！");
            return ResponseBase.error("删除用户失败，请稍后重试！");
        } catch (Exception e) {
            logger.error("删除失败",e);
            return ResponseBase.error("删除用户失败，请稍后重试！");
        }
    }

    @Override
    public ResponseBase addOrUpdateIdentifyUser(IdentifyUser identifyUser) {
        //1、先判断数据库中是否有该用户，
        IdentifyUser isExistIdentifyUser = identifyUserDao.selectByUserNoAndBuNo(identifyUser.getUserNo(),identifyUser.getBuNo());

        //如果用户不存在，返回错误信息，提示要先对该用户进行声纹注册
        if (isExistIdentifyUser == null){
            logger.info("添加的用户不存在");
            return ResponseBase.error("添加的用户还未进行声纹注册，无法设置黑白名单!");
        }else {
            identifyUser.setId(isExistIdentifyUser.getId());
            identifyUser.setEnrolTime((isExistIdentifyUser.getEnrolTime()));
            return updateIdentifyUser(identifyUser);
        }
    }

    @Override
    public ResponseBase getIdentifyUserByID(Long id) {
        try {
            List<IdentifyUser> identifyUser = identifyUserDao.selectAll(new IdentifyUser(id));
            return ResponseBase.ok(identifyUser.get(0));
        } catch (Exception e) {
            logger.error("查询用户失败，请联系网站管理员！");
            return ResponseBase.error("查询用户失败，请联系网站管理员！");
        }
    }

    @Override
    public List<User> selectAllIdentifyUser(User user) {
        return userDao.selectAllIdentifyUser(user);
    }

    @Override
    public ResponseBase deleteIdenfiyUserByIds(String ids) throws Exception{

//        List<String> listIds = new ArrayList<>(Arrays.asList(ids.split(",")));
        String[] userIds = ids.split(",");
        List<Long> userIdList = new ArrayList<>();
        for (int i = 0; i < userIds.length; i++){
            userIdList.add(Long.valueOf(userIds[i]));
        }
        int i = userDao.deleteByIds(userIdList);
        if(i>0){
            String results = "";
            for (int j = 0; j < userIds.length; j++){
                try {
                    String delete = IdentifyFunction.doDelete(getUseUrl() + "deleteSpeaker", IdentifyFunction.deletePayload(userIds[j]));
                    results = results + "--" + delete;
                } catch (Exception e) {
                    logger.error("删除用户id为" + userIds[j] +"模型失败", e);
                }
            }
            logger.info("删除用户模型结果" + results);
            return ResponseBase.ok("删除用户成功！");
        }
        logger.info("受影响行数为0，删除用户失败！");
        return ResponseBase.error("删除用户失败，请稍后重试！");
    }


    private ResponseBase updateIdentifyUser(IdentifyUser identifyUser){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        identifyUser.setUpdateTime(sdf.format(new Date()));
//            rollList.setUpdateBy();
        try {
            int i = identifyUserDao.updateByPrimaryKeySelective(identifyUser);
            if(i>0){
                return ResponseBase.ok("设置用户黑白名单成功！");
            }
            logger.info("受影响行数为0，设置用户黑白名单失败！");
            return ResponseBase.error("设置用户黑白名单失败，请稍后重试！");
        } catch (Exception e) {
            logger.error("设置用户黑白名单失败",e);
            return ResponseBase.error("设置用户黑白名单失败，请稍后重试！");
        }
    }

}
