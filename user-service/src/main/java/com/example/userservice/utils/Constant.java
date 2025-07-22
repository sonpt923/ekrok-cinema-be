package com.example.userservice.utils;

public class Constant {

    public static final Long OTP_TIME = 60L;

    public static final Long TTL = 60L;

    public static final String YES = "yes";

    public static final String SELF_CREATE = "default";

    public static final String USER_SESSION = "user-session";

    public interface AP_DOMAIN {

        String ADM_OTP_CODE = "ADM_OTP";

        String CLIENT_OTP_CODE = "CLIENT_OTP";

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
