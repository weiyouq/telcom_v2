package cn.xs.sh.telcom.dao.management;


import cn.xs.sh.telcom.bean.ActivityLog;
import cn.xs.sh.telcom.dao.IBaseDao;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/8/4 14:03
 */
public interface IActivityLogDao extends IBaseDao<Long, ActivityLog> {


    List<ActivityLog> selectAll(ActivityLog activityLog);

    List<ActivityLog> selectAllIdentifylog(ActivityLog activityLog);
}
