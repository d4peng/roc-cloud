package icu.d4peng.cloud.common.core.exception;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 10:10
 * @description BaseException:基础异常
 */
public abstract class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}