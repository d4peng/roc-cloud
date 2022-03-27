package icu.d4peng.cloud.common.captcha.properties;

import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.enums.CaptchaEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> CaptchaProperties:验证码属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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
