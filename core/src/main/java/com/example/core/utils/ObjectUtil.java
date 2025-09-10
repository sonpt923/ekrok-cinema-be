package com.example.core.utils;

import java.util.List;

public class ObjectUtil {


    public static boolean objectIsNullorEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        if (obj instanceof List) {
            return ((List<?>) obj).isEmpty();
        }
        return false;
    }

}
