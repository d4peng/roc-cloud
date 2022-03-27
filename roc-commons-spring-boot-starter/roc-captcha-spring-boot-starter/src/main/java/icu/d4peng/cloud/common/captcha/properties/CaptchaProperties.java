package icu.d4peng.cloud.common.captcha.properties;

import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.enums.CaptchaEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 10:16
 * @description CaptchaProperties:验证码属性配置
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = CaptchaProperties.PREFIX)
public class CaptchaProperties {
    /**
     * 前缀:roc.captcha
     */
    public static final String PREFIX = "roc.captcha";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * 验证码类型:默认PNG
     */
    private CaptchaEnum type = CaptchaEnum.Spec;
    /**
     * 字体类型:默认1
     */
    private int fontType = Captcha.FONT_1;
    /**
     * 文本类型:默认类型
     */
    private int textType = Captcha.TYPE_DEFAULT;
    /**
     * 验证码文本长度:默认4位
     */
    private int textLength = 4;
    /**
     * 宽度:默认130
     */
    private int width = 130;
    /**
     * 高度:默认48
     */
    private int height = 48;
}
