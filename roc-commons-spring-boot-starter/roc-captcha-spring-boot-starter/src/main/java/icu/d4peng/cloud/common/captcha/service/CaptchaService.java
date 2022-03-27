package icu.d4peng.cloud.common.captcha.service;

import com.wf.captcha.base.Captcha;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 10:32
 * @description CaptchaService:验证码服务
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
