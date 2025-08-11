package com.example.core.utils;

import java.util.List;

public class ObjectUtil {

    public static Boolean objectIsNullorEmpty(Object str) {
        if (str != null) {
            if (str instanceof String) {
                return true;
            }
            if(str instanceof List){
                return true;
            }
            return false;
        }
        return true;
    }

}
