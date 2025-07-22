package com.example.core.utils;

public class BaseConstant {

    public interface  SUCCESS {

        String SUCCESS = "API200";

        String CREATE_SUCCESS = "API201";

        String UPDATE_SUCCESS = "API202";

        String DELETE_SUCCESS = "API203";

    }


    public interface ERORRS {
        String SYSTEM = "APP001";
        String DUPLICATE = "APP002";

        String NOT_NULL = "APP003";
        String USER_NAME_EMAIL_EXIST = "APP004";
        String NOT_DECLARE = "APP005";

        String NOT_HAVE_PERMISSION = "APP006";

        String USER_NAME_EMAIL_NOT_EXIST = "APP007";

        String UNIQUE = "API500";
        String LOGIC = "API501";
        String DATA_USING = "API502";
        String DATA_NOT_FOUND = "API503";
        String MAX_LENGTH = "APP300";
        String PASSWORD = "APP301";
        String PASSWORD_NOT_NULL = "APP302";
        String APP_NOT_COMPARE = "APP303";
        String PERMIT = "APP304";
        String APP305 = "APP305";
        String APP306 = "APP306";
        String PASS_001 = "APP003";
        String PASS_002 = "APP004";
        String PASS_003 = "APP005";
        String PASS_004 = "APP006";
        String PASS_007 = "APP007";
        String PASS_008 = "APP008";
        String OTP_000 = "OTP000";
        String OTP_001 = "OTP001";
        String LOCK_TIME = "APP999";
        String CREATE_STAFF = "API504";

        String STATUS_ALIAS = "APP982";
    }

    public static final Long OTP_TIME = 60L;

    public static final Long TTL = 60L;

    public static final String YES = "yes";

    public static final String SELF_CREATE = "default";

    public static final String USER_SESSION = "user-session";

    public interface CURD {

        String CREATE = "C";

        String UPDATE = "U";

        String IN_ACTIVE = "I";

    }

    public static final Integer OTP_LENGTH = 9;

}
