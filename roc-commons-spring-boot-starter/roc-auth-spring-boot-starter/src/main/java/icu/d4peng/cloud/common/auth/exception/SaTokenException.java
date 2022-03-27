package icu.d4peng.cloud.common.auth.exception;

import icu.d4peng.cloud.common.core.exception.BaseException;

/**
 * <p> SaTokenException: SaToken异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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
