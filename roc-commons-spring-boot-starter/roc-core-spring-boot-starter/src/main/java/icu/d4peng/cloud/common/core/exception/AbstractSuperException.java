package icu.d4peng.cloud.common.core.exception;

/**
 * <p> BaseException:基础异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public abstract class AbstractSuperException extends RuntimeException {
    /**
     * 状态码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    public AbstractSuperException() {
        super();
    }

    public AbstractSuperException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AbstractSuperException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public AbstractSuperException(Throwable throwable) {
        super(throwable);
    }

    public AbstractSuperException(int code, String msg, Throwable throwable) {
        super(msg, throwable);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public AbstractSuperException setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AbstractSuperException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}