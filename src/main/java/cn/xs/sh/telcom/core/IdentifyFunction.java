package cn.xs.sh.telcom.core;


import cn.xs.sh.telcom.utils.HttpUtils;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @author kenny_peng
 * @created 2019/11/7 11:14
 */
public class IdentifyFunction {

    public static String doDelete(String deleteUrl, String deletePayload) throws Exception {
        String deleteResult = HttpUtils.doPost(deleteUrl, deletePayload);
        return deleteResult;
    }
    public static boolean isDeleteSuccess(String deleteResult) throws Exception{
        Map<String,Object> deleteResultMap = JSONObject.fromObject(deleteResult);
        if (deleteResult.contains("retCode") && ((String)deleteResultMap.get("retCode")).equals("0")){
            return true;
        }
        return false;
    }
    public static String deletePayload(String userId){
        String deleteString ="{\"userId\":\""+ userId+"\"}";
        return deleteString;
    }



}
