package cn.xs.sh.telcom.service;


import cn.xs.sh.telcom.bean.IdentifyUser;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;

import java.util.List;

/**
 * 黑白名单管理业务逻辑接口
 * @author kenny_peng
 * @created 2019/7/17 15:05
 */
public interface IIdentifyUserService {

    /**
     * 查询列黑白名单表中所有值
     * @param identifyUser
     * @return      黑白名单表集合
     */
    List<IdentifyUser> selectAll(IdentifyUser identifyUser);

    /**
     * 根据主键查找黑白名单
     * @param id    主键
     * @return      黑白名单实体类
     */
    IdentifyUser selectByPrimaryKey(Long id);

    /**
     * 根据主键集合修改用户为为备注黑白名单
      * @param ids  用户编号集合
     * @return
     */
    ResponseBase deleteByIds(String ids);

    /**
     * 如果数据库不存在该用户编号，添加该用户编号，如果存在则根据用户输入的用户编号，更新用户黑白名单状态，
     * @param identifyUser  用户对象
     * @return
     */
    ResponseBase addOrUpdateIdentifyUser(IdentifyUser identifyUser);

    /**
     * 根据ID查找用户
     * @param id    主键
     * @return
     */
    ResponseBase getIdentifyUserByID(Long id);

    List<User> selectAllIdentifyUser(User user);

    ResponseBase deleteIdenfiyUserByIds(String ids) throws Exception;
}
