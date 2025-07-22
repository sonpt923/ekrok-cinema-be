package com.example.core.utils;

public class Constant {

    public interface ERORRS {
        
    }

    public static final Long OTP_TIME = 60L;

    public static final Long TTL = 60L;

    public static final String YES = "yes";

    public static final String SELF_CREATE = "default";

    public static final String USER_SESSION = "user-session";

    public interface AP_DOMAIN {

        String OTP_CODE = "OTP";

    }

    public interface user {

        Integer ACTIVE = 1;

        Integer IN_ACTIVE = 0;

    }

    public interface mail_type {

        String CREATE = "C";

        String UPDATE = "U";

        String IN_ACTIVE = "I";

    }

    public static final Integer OTP_LENGTH = 9;

}
