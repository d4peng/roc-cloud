package icu.d4peng.cloud.common.message.exception;

import icu.d4peng.cloud.common.core.exception.AbstractSuperException;

/**
 * <p> MessageException: Message异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-06
 */
public class MessageException extends AbstractSuperException {
    public MessageException() {
        super();
    }

    public MessageException(String msg) {
        super(msg);
    }

    public MessageException(int code, String msg) {
        super(code, msg);
    }

    public MessageException(Throwable throwable) {
        super(throwable);
    }

    public MessageException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
