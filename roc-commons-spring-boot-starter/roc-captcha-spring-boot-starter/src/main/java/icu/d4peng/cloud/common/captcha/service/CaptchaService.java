package icu.d4peng.cloud.common.captcha.service;

import com.wf.captcha.base.Captcha;

/**
 * <p> CaptchaService:验证码服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface CaptchaService {
    /**
     * 获得Captcha对象
     *
     * @return Captcha对象
     */
    Captcha getCaptcha();

    /**
     * 变成base64
     *
     * @return base图片
     */
    String toBase64();
}
