package cn.xs.sh.telcom.dao.management;


import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.dao.IBaseDao;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/8/3 22:21
 */
public interface IUserDao extends IBaseDao<Long, User> {
    User selectByUserNo(String userNo);

    List<User> selectAllIdentifyUser(User user);

    List<User> selectAllUaUser(User user);

    List<User> selectAllUaUserCount();

    int deleteByIds(List<Long> listIds);

    List<User> selectUserEnrolInfo(String userId);

    List<User> selectUaUserCountByDate(String date);
}
