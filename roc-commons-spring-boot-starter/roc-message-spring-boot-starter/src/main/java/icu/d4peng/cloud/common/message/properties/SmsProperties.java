package icu.d4peng.cloud.common.message.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> SmsProperties:阿里云短信配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = SmsProperties.PREFIX)
public class SmsProperties {
    /**
     * 前缀名
     */
    public static final String PREFIX = "roc.sms";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * accessKeyId
     */
    private String accessKeyId;
    /**
     * accessKeySecret
     */
    private String accessKeySecret;
    /**
     * 签名
     */
    private String signName;
    /**
     * 模板值
     */
    private String templateCode;

    public boolean isEnabled() {
        return enabled;
    }

    public SmsProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public SmsProperties setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public SmsProperties setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public String getSignName() {
        return signName;
    }

    public SmsProperties setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public SmsProperties setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("accessKeyId", accessKeyId)
                .append("accessKeySecret", accessKeySecret)
                .append("signName", signName)
                .append("templateCode", templateCode)
                .toString();
    }
}
