package cn.xs.sh.telcom.web;


import cn.xs.sh.telcom.bean.IdentifyUser;
import cn.xs.sh.telcom.bean.User;
import cn.xs.sh.telcom.config.PageRequest;
import cn.xs.sh.telcom.config.returndefine.ResponseBase;
import cn.xs.sh.telcom.service.IIdentifyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 黑白名单对外提供restful API接口类
 * @author kenny_peng
 * @created 2019/7/17 15:14
 */
@Controller
public class IdentifyUserController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IIdentifyUserService identifyUserService;



//    @RequestMapping("write/getWrite")
//    @ResponseBody
//    public ResponseBase getOneWrite(long rollListId){
//        try {
//            RollList rollList = rollListService.selectByPrimaryKey(rollListId);
//            return ResponseBase.ok(rollList);
//        } catch (Exception e) {
//            logger.error("error",e);
//            return ResponseBase.error("获取名单失败，请重试！");
//        }
//    }

    @GetMapping("/roll/lists")
    @ResponseBody
    public Map<String, Object> selectAll(PageRequest request, IdentifyUser identifyUser){
        Map<String, Object> stringObjectMap = super.selectByPageNumSize(request, () -> identifyUserService.selectAll(identifyUser));
        return stringObjectMap;
    }

    @RequestMapping("roll/delete")
    @ResponseBody
    public ResponseBase deleteRollById(String ids){
        ResponseBase responseBase = identifyUserService.deleteByIds(ids);
        return responseBase;
    }

    @PostMapping("roll/add")
    @ResponseBody
    public ResponseBase addRoll(IdentifyUser identifyUser){
        ResponseBase responseBase = identifyUserService.addOrUpdateIdentifyUser(identifyUser);
        return responseBase;
    }

    @RequestMapping("roll/findById")
    @ResponseBody
    public ResponseBase getRollByID(Long id){
        ResponseBase responseBase = identifyUserService.getIdentifyUserByID(id);
        return responseBase;
    }

    @RequestMapping("roll/update")
    @ResponseBody
    public ResponseBase updateRoll(IdentifyUser identifyUser){
        ResponseBase responseBase = identifyUserService.addOrUpdateIdentifyUser(identifyUser);
        return responseBase;
    }


    @RequestMapping("rollUser")
    public String getRollUser(){
        return "IdentifyUserList/IdentifyUserList";
    }

    @GetMapping("roll/userLists")
    @ResponseBody
    public Map<String, Object> selectAllUserLists(PageRequest request, User user){
        return super.selectByPageNumSize(request, ()-> identifyUserService.selectAllIdentifyUser(user));
    }

    @RequestMapping("roll/deleteUser")
    @ResponseBody
    public ResponseBase deleteIdentifyUserById(String ids){
        try {
            ResponseBase responseBase = identifyUserService.deleteIdenfiyUserByIds(ids);
            return responseBase;
        } catch (Exception e) {
            logger.error("删除用户失败", e);
            return ResponseBase.error("删除用户失败");
        }
    }
}
