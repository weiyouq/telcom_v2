package cn.xs.sh.telcom.dao.management;


import cn.xs.sh.telcom.bean.IdentifyUser;
import cn.xs.sh.telcom.dao.IBaseDao;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/8/3 21:55
 */
public interface IIdentifyUserDao extends IBaseDao<Long, IdentifyUser> {
    List<IdentifyUser> selectAll(IdentifyUser identifyUser);

    int deleteByIds(List<String> listIds);

    IdentifyUser selectByUserNoAndBuNo(String userNo, String buNo);
}
