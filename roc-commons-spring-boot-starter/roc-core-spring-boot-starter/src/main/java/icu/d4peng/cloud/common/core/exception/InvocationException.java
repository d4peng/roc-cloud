package icu.d4peng.cloud.common.core.exception;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-27 10:21
 * @description InvocationException:
 */
public class InvocationException extends BaseException {
    public InvocationException() {
        super();
    }

    public InvocationException(String message) {
        super(message);
    }

    public InvocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvocationException(Throwable cause) {
        super(cause);
    }

    protected InvocationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
