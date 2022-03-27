package icu.d4peng.cloud.common.core.exception;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-27 13:15
 * @description InstanceException:
 */
public class InstanceException extends BaseException {
    public InstanceException() {
        super();
    }

    public InstanceException(String message) {
        super(message);
    }

    public InstanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstanceException(Throwable cause) {
        super(cause);
    }

    protected InstanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
