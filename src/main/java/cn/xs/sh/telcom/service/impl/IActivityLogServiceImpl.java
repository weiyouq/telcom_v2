package cn.xs.sh.telcom.service.impl;

import cn.xs.sh.telcom.bean.ActivityLog;
import cn.xs.sh.telcom.dao.management.IActivityLogDao;
import cn.xs.sh.telcom.service.IActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/8/4 13:57
 */
@Service
public class IActivityLogServiceImpl implements IActivityLogService {

    @Autowired
    private IActivityLogDao activityLogDao;

    @Override
    public List<ActivityLog> selectAll(ActivityLog activityLog) {
        return activityLogDao.selectAll(activityLog);
    }

    @Override
    public List<ActivityLog> selectAllIdentifylog(ActivityLog activityLog) {

        return activityLogDao.selectAllIdentifylog(activityLog);
    }
}
