package icu.d4peng.cloud.common.auth.exception;

import icu.d4peng.cloud.common.core.exception.AbstractSuperException;

/**
 * <p> SaTokenException: SaToken异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SaTokenException extends AbstractSuperException {

    public SaTokenException() {
        super();
    }

    public SaTokenException(String msg) {
        super(msg);
    }

    public SaTokenException(int code, String msg) {
        super(code, msg);
    }

    public SaTokenException(Throwable throwable) {
        super(throwable);
    }

    public SaTokenException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
