package com.example.core.utils;

import java.util.Map;

public class DataUtil {

    public static String mapValueToParam(String body, Map mapValue) {
        while (body.contains("{") && body.contains("}")) {
            int indexStart = body.indexOf("{");
            int indexEnd = body.indexOf("}");
            String strParam = body.substring(indexStart, indexEnd + 1);
            strParam = strParam.replaceAll(":", "");
            String strKey = strParam.replaceAll("\\{", "");
            strKey = strKey.replaceAll("}", "");
            strParam = "\\" + strParam;
            body = body.replaceAll(strParam, mapValue.get(strKey) == null ? "null" : ("\"" + StringUtil.nvl(mapValue.get(strKey), "") + "\"")).toString();
        }
        return body;
    }




}
