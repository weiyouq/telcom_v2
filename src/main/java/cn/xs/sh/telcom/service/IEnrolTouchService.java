package cn.xs.sh.telcom.service;


import cn.xs.sh.telcom.bean.EnrolTouch;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/10/22 13:40
 */
public interface IEnrolTouchService {

    public List<EnrolTouch> selectAll(EnrolTouch enrolTouch);

    List<User> selectAllUser(User user);

    List<User> selectAllUserCount();

    ResponseBase deleteUserByIds(String ids) throws Exception;

    List<User> selectUserEnrolInfo(String userId);

    List<User> selectUaUserCountByDate(String beginTime);
}
