package cn.xs.sh.telcom.config.returndefine;

import java.util.HashMap;

/**
 * 返回信息模板
 * @author kenny_peng
 * @created 2019/7/18 16:53
 */
@SuppressWarnings("serial")
public class ResponseBase extends HashMap<String, Object> {

    //成功
    private static final Integer SUCCESS = 0;

    //失败、异常
    private static final Integer Failed = 500;

    public ResponseBase(){
        put("code", SUCCESS);
        put("msg", "操作成功");
    }

    public static ResponseBase ok(Object o){
        ResponseBase responseTemplate = new ResponseBase();
        responseTemplate.put("code", SUCCESS);
        responseTemplate.put("msg", o);
        return responseTemplate;
    }

    public static ResponseBase ok(){
        return new ResponseBase();
    }

    public static ResponseBase error(){
        return ResponseBase.error("");
    }

    public static ResponseBase error(Object o){
        ResponseBase rst = new ResponseBase();
        rst.put("code", Failed);
        rst.put("msg", o);
        return rst;
    }


    @Override
    public ResponseBase put(String key, Object value){
        super.put(key, value);
        return this;
    }




}
