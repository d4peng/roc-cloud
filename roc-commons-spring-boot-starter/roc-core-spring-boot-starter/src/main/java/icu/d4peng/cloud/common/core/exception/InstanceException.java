package icu.d4peng.cloud.common.core.exception;

/**
 * <p> InstanceException:实例化异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class InstanceException extends AbstractSuperException {
    public InstanceException() {
        super();
    }

    public InstanceException(String msg) {
        super(msg);
    }

    public InstanceException(int code, String msg) {
        super(code, msg);
    }

    public InstanceException(Throwable throwable) {
        super(throwable);
    }

    public InstanceException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
