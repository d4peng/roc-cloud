package icu.d4peng.cloud.common.captcha.exception;

import icu.d4peng.cloud.common.core.exception.BaseException;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 10:27
 * @description CaptchaException: 验证码异常
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
