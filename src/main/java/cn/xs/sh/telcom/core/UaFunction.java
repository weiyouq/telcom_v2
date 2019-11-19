package cn.xs.sh.telcom.core;

import cn.xs.sh.telcom.utils.HttpUtils;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @author kenny_peng
 * @created 2019/11/7 11:14
 */
public class UaFunction {

    /**
     * 删除用户
     * @param deleteUrl
     * @param deletePayload
     * @return
     * @throws Exception
     */
    public static String doDelete(String deleteUrl, String deletePayload) throws Exception{
        String deleteResult = HttpUtils.doPost(deleteUrl, deletePayload);
        return deletePayload;
    }
    public static boolean isDeleteSuccess(String deleteResult) throws Exception{
        Map<String, Object> deleteResultMap = JSONObject.fromObject(deleteResult);
        if (deleteResultMap.containsKey("outcome") && ((String)deleteResultMap.get("outcome")).equals("SUCCESS")){
            return true;
        }
        return false;
    }
    public static String deletePayload(String userID){
        String deletePayload = "{\n" +
                "  \"serviceData\": {\n" +
                "    \"loggingId\": \"log-20180104145205104\"\n" +
                "  },\n" +
                "  \"userData\": {\n" +
                "    \"identifier\": \""+ userID +"\"\n" +
                "  },\n" +
                "  \"processingInformation\": {\n" +
                "    \"biometric\": {\n" +
                "      \"type\": \"text-dependent\",\n" +
                "      \"mode\": \"td_fuse_16_atn_v2\"\n" +
                "    },\n" +
                "    \"audioCharacteristics\": {\n" +
                "      \"samplingRate\": \"16000\",\n" +
                "      \"format\": \"pcm16\"\n" +
                "    },\n" +
                "    \"metaInformation\": [\n" +
                "      {\n" +
                "        \"key\": \"usage-context\",\n" +
                "        \"value\": {\n" +
                "          \"value\": \"default\",\n" +
                "          \"encrypted\": \"false\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        return deletePayload;
    }

}
