package cn.xs.sh.telcom.web;

import cn.xs.sh.telcom.bean.ActivityLog;
import cn.xs.sh.telcom.bean.EnrolTouch;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.PageRequest;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;
import cn.xs.sh.telcom.service.IActivityLogService;
import cn.xs.sh.telcom.service.IEnrolTouchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1:1和1：n记录查询
 * @author kenny_peng
 * @created 2019/8/4 13:51
 */
@Controller
public class RecordController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IActivityLogService activityLogService;
    @Autowired
    private IEnrolTouchService enrolTouchService;

    @RequestMapping("uaUser")
    public String getUaUser(){
        return "uauser/uauser";
    }
    @RequestMapping("/uaUser/userLists")
    @ResponseBody
    public Map<String, Object> selectAllUser(PageRequest request, User user){
        logger.info(user.getUserId() + "---" + user.getUserState());

        return super.selectByPageNumSize(request, ()-> enrolTouchService.selectAllUser(user));
    }
    @RequestMapping("uaUser/userListsDelete")
    @ResponseBody
    public ResponseBase deleteUserByIds(String ids){
        try {
            return enrolTouchService.deleteUserByIds(ids);
        } catch (Exception e) {
            logger.error("删除用户失败", e);
            return ResponseBase.error("删除用户失败");
        }
    }

    @RequestMapping("uaUserCount")
    public String getUaUserCount(){
        return "uauser/uausercount";
    }
    @RequestMapping("/uaUserCount/uaUserCount")
    @ResponseBody
    public Map<String, Object> selectAllUserCount(PageRequest request, String beginTime){
        if (beginTime == null || beginTime.equals("")){
            return super.selectByPageNumSize(request, ()->enrolTouchService.selectAllUserCount());
        }else {
            return super.selectByPageNumSize(request,()->enrolTouchService.selectUaUserCountByDate(beginTime));
        }


    }



    @RequestMapping("uaUserSearch")
    public String getUaUserSearch(){return "uauser/uaUserSearch.html";}
    @RequestMapping("/uaUserSearch/uaUserSearch")
    @ResponseBody
    public Map<String, Object> searchEnrolUserInfo(PageRequest request,String userNo){
        return super.selectByPageNumSize(request,()->{
            List<User> userList = enrolTouchService.selectUserEnrolInfo(userNo);
//            if (userList == null || userList.size()<1){
//                userList = new ArrayList<>();
//                User user = new User();
//                user.setUserId("用户不存在");
//                userList.add(user);
//            }
            return userList;
        });
    }


    @RequestMapping("uaenrollog")
    public String getUaEnrolLog(){
        return "ualog/uaenrollog";
    }

    @RequestMapping("/uaenrollog/lists")
    @ResponseBody
    public Map<String, Object> selectUaEnrolAll(PageRequest request, EnrolTouch enrolTouch) {
        Map<String, Object> stringObjectMap = super.selectByPageNumSize(request, () -> enrolTouchService.selectAll(enrolTouch));
        return stringObjectMap;
    }

    @RequestMapping("identifylog")
    public String getIdentifylog(){
        return "identifylog/identifylog";
    }

    @RequestMapping("/identifylog/lists")
    @ResponseBody
    public Map<String, Object> selectAllIdentifylog(PageRequest request, ActivityLog activityLog) {
        Map<String, Object> stringObjectMap = super.selectByPageNumSize(request, () -> activityLogService.selectAllIdentifylog(activityLog));
        return stringObjectMap;
    }

}
