package cn.xs.sh.telcom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kenny_peng
 * @created 2019/8/3 21:27
 */
@Controller
public class HomeController {

    @RequestMapping("/myindex")
    public String testIn(){
        return "/index";
    }

    @RequestMapping("/myapi")
    public String tst(){
        return "/test";
    }

}
