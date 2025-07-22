package com.example.apigateway.util;

import com.example.core.utils.BaseConstant;

public class Constant extends BaseConstant {

    public static final String TRACE_ID_HEADER = "X-Trace-Id";

    public static final String YES = "yes";

    public static final String AUTHEN_KEY = "X-Authen-Key";

    public interface STATUS {

        Long ACTIVE = 1L;

        Long IN_ACTIVE = 0L;
    }

    public interface RESPONSE_STATUS {

        String SUCCESS = "SUCCESS";

        String ERROR = "ERROR";

        String ERROR_WITH_PAR = "ERROR_WITH_PAR";
    }

    public static final String TEMPLE_SPLIT = "|!@#$%^&*()|";


}
