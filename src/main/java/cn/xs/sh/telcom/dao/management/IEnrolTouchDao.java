package cn.xs.sh.telcom.dao.management;


import cn.xs.sh.telcom.bean.EnrolTouch;
import cn.xs.sh.telcom.dao.IBaseDao;

import java.util.List;

/**
 * @author kenny_peng
 * @created 2019/10/22 13:42
 */
public interface IEnrolTouchDao extends IBaseDao<Long, EnrolTouch> {


    List<EnrolTouch> selectAll(EnrolTouch enrolTouch);
}
