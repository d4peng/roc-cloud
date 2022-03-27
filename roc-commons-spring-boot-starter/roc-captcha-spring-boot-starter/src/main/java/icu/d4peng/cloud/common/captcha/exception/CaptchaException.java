package icu.d4peng.cloud.common.captcha.exception;

import icu.d4peng.cloud.common.core.exception.BaseException;

/**
 * <p> CaptchaException: 验证码异常
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class CaptchaException extends BaseException {
    /**
     * 未找到类型
     */
    public static final String NO_TYPE = "captcha type nod found!";

    public CaptchaException() {
        super();
    }

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(Throwable cause) {
        super(cause);
    }

    protected CaptchaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
