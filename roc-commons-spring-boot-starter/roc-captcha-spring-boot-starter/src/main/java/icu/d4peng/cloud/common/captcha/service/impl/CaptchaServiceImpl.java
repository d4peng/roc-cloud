package icu.d4peng.cloud.common.captcha.service.impl;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.exception.CaptchaException;
import icu.d4peng.cloud.common.captcha.properties.CaptchaProperties;
import icu.d4peng.cloud.common.captcha.service.CaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> CaptchaServiceImpl: 验证码实现类
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class CaptchaServiceImpl implements CaptchaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaServiceImpl.class);
    private final Captcha captcha;

    public CaptchaServiceImpl(CaptchaProperties captchaProperties) {
        switch (captchaProperties.getType()) {
            case Arithmetic:
                this.captcha = new ArithmeticCaptcha();
                break;
            case Chinese:
                this.captcha = new ChineseCaptcha();
                break;
            case ChineseGif:
                this.captcha = new ChineseGifCaptcha();
                break;
            case Gif:
                this.captcha = new GifCaptcha();
                break;
            case Spec:
                this.captcha = new SpecCaptcha();
                break;
            default:
                throw new CaptchaException(CaptchaException.NO_TYPE);
        }
        try {
            captcha.setFont(captchaProperties.getFontType());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new CaptchaException(e.getCause());
        }
        captcha.setCharType(captchaProperties.getTextType());
        captcha.setLen(captchaProperties.getTextLength());
        captcha.setHeight(captchaProperties.getHeight());
        captcha.setWidth(captchaProperties.getWidth());
    }

    @Override
    public Captcha getCaptcha() {
        return this.captcha;
    }

    @Override
    public String toBase64() {
        return this.captcha.toBase64();
    }
}
