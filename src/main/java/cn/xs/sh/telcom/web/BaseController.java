package cn.xs.sh.telcom.web;

import cn.xs.sh.telcom.config.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 错误异常处理类
 * @author kenny_peng
 * @created 2019/7/17 15:24
 */
@Controller
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    public String exptionHandler(HttpServletRequest request, Exception e){
        request.setAttribute("exception", e);
        logger.error("Error", e);
        return "error/500";
    }

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(PageRequest request, Supplier<?> s) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }

}
