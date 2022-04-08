package icu.d4peng.cloud.user.exception;

import icu.d4peng.cloud.common.core.exception.AbstractSuperException;

/**
 * <p> UserException:用户异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class UserException extends AbstractSuperException {
    public UserException() {
        super();
    }

    public UserException(String msg) {
        super(msg);
    }

    public UserException(int code, String msg) {
        super(code, msg);
    }

    public UserException(Throwable throwable) {
        super(throwable);
    }

    public UserException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
