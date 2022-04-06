package icu.d4peng.cloud.common.core.exception;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> InvocationException:
 * @since 2022-03-27 15:43
 */
public class InvocationException extends AbstractSuperException {
    public InvocationException() {
        super();
    }

    public InvocationException(String msg) {
        super(msg);
    }

    public InvocationException(int code, String msg) {
        super(code, msg);
    }

    public InvocationException(Throwable throwable) {
        super(throwable);
    }

    public InvocationException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
