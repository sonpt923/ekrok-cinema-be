package com.example.core.utils;

public class ObjectUtil {

    public static Boolean objectIsNullorEmpty(Object str) {
        if (str != null) {
            if (str instanceof String) {
                if (str.toString().trim().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

}
