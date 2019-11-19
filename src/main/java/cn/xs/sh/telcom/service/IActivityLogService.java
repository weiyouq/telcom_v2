package cn.xs.sh.telcom.service;


import cn.xs.sh.telcom.bean.ActivityLog;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/8/4 13:57
 */
public interface IActivityLogService {


    List<ActivityLog> selectAll(ActivityLog activityLog);

    List<ActivityLog> selectAllIdentifylog(ActivityLog activityLog);
}
