package icu.d4peng.cloud.common.captcha.exception;

import icu.d4peng.cloud.common.core.exception.AbstractSuperException;

/**
 * <p> CaptchaException: 验证码异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class CaptchaException extends AbstractSuperException {
    /**
     * 未找到类型
     */
    public static final String NO_TYPE = "captcha type nod found!";

    public CaptchaException() {
        super();
    }

    public CaptchaException(String msg) {
        super(msg);
    }

    public CaptchaException(int code, String msg) {
        super(code, msg);
    }

    public CaptchaException(Throwable throwable) {
        super(throwable);
    }

    public CaptchaException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }
}
