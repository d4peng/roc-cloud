package icu.d4peng.cloud.common.auth.exception;

import icu.d4peng.cloud.common.core.exception.BaseException;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 09:47
 * @description SaTokenException: SaToken异常
 */
public class SaTokenException extends BaseException {

    public SaTokenException() {
        super();
    }

    public SaTokenException(String message) {
        super(message);
    }

    public SaTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaTokenException(Throwable cause) {
        super(cause);
    }

    protected SaTokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
