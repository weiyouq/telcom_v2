package cn.xs.sh.telcom.service.impl;


import cn.xs.sh.telcom.bean.EnrolTouch;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;
import cn.xs.sh.telcom.core.UaFunction;
import cn.xs.sh.telcom.dao.management.IEnrolTouchDao;
import cn.xs.sh.telcom.dao.management.IUserDao;
import cn.xs.sh.telcom.service.IEnrolTouchService;
import cn.xs.sh.telcom.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/10/22 13:40
 */
@Service
public class EnrolTouchServiceImpl implements IEnrolTouchService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IEnrolTouchDao enrolTouchDao;
    @Autowired
    private IUserDao userDao;

    private static Integer MAX_URL_SUM = 0;
    private String[] uaBaseUrl;
    @Value("${ua.address}")
    public void setUaEnrolAddress(String address) {
        uaBaseUrl = address.split(",");
        MAX_URL_SUM = uaBaseUrl.length * 10000;
    }
    private int urlSum = 0;
    /** 均衡url */
    private synchronized String getUaUseUrl() {
        if (urlSum > MAX_URL_SUM) {
            urlSum = 0;
        }
        return uaBaseUrl[urlSum++ % uaBaseUrl.length];
    }

    @Override
    public List<EnrolTouch> selectAll(EnrolTouch enrolTouch) {
        List<EnrolTouch> enrolTouchList = enrolTouchDao.selectAll(enrolTouch);
        logger.info("查询1:1注册大小：" + enrolTouchList.size());
        return enrolTouchList;
    }

    @Override
    public List<User> selectAllUser(User user) {
        return userDao.selectAllUaUser(user);
    }

    @Override
    public List<User> selectAllUserCount() {
        return userDao.selectAllUaUserCount();
    }

    @Override
    public ResponseBase deleteUserByIds(String ids) throws Exception {
        String[] userIds = ids.split(",");
        List<Long> listIds = new ArrayList<>();
        for (int i = 0; i < userIds.length; i++){
            listIds.add(Long.valueOf(userIds[i]));
        }
        //1、删除用户表
        int deletUserResult = userDao.deleteByIds(listIds);
        if (deletUserResult > 0){
            //2、删除用户模型
            String deletes = "";
            for (int i =0; i < userIds.length; i++){
                try {
                    String deleteResult = UaFunction.doDelete(getUaUseUrl() + "deleteSpeaker", UaFunction.deletePayload(userIds[i]));
                    deletes = deletes + "--" + deleteResult;
                } catch (Exception e) {
                    logger.error("删除用户模型失败", e);
                }
            }
            logger.info(deletes);
            return ResponseBase.ok("删除成功");
        }
        return ResponseBase.error("删除失败");
    }

    @Override
    public List<User> selectUserEnrolInfo(String userId){
        return userDao.selectUserEnrolInfo(userId);
    }

    @Override
    public List<User> selectUaUserCountByDate(String beginTime) {
        String replacedTime = beginTime.replace("-", "");
        List<User> userList = userDao.selectUaUserCountByDate(replacedTime);
        return userList;
    }
}
