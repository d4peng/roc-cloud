package icu.d4peng.cloud.common.captcha.service;

import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.CaptchaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CaptchaApplication.class)
public class CaptchaServiceTest {
    private final Captcha captcha;

    @Autowired
    public CaptchaServiceTest(CaptchaService captchaService) {
        this.captcha = captchaService.getCaptcha();
    }


    @Test
    public void getCaptcha() {
        System.out.println(this.captcha.text());
    }

    @Test
    public void toBase64() {
        System.out.println(this.captcha.toBase64());
    }
}