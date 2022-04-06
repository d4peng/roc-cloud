package icu.d4peng.cloud.common.captcha.properties;

import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.enums.CaptchaEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> CaptchaProperties:验证码属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
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

    public boolean isEnabled() {
        return enabled;
    }

    public CaptchaProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public CaptchaEnum getType() {
        return type;
    }

    public CaptchaProperties setType(CaptchaEnum type) {
        this.type = type;
        return this;
    }

    public int getFontType() {
        return fontType;
    }

    public CaptchaProperties setFontType(int fontType) {
        this.fontType = fontType;
        return this;
    }

    public int getTextType() {
        return textType;
    }

    public CaptchaProperties setTextType(int textType) {
        this.textType = textType;
        return this;
    }

    public int getTextLength() {
        return textLength;
    }

    public CaptchaProperties setTextLength(int textLength) {
        this.textLength = textLength;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public CaptchaProperties setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public CaptchaProperties setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("type", type)
                .append("fontType", fontType)
                .append("textType", textType)
                .append("textLength", textLength)
                .append("width", width)
                .append("height", height)
                .toString();
    }
}
