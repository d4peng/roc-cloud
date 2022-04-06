package icu.d4peng.cloud.common.message.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> EmailProperties:邮件的配置属性
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = EmailProperties.PREFIX)
public class EmailProperties extends MailProperties {
    /**
     * 前缀名
     */
    public static final String PREFIX = "roc.email";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * 模板位置前缀
     */
    private String templatePrefix = "src/main/resources/templates/";
    /**
     * 模板位置前缀
     */
    private String templateSuffix = ".html";

    public boolean isEnabled() {
        return enabled;
    }

    public EmailProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getTemplatePrefix() {
        return templatePrefix;
    }

    public EmailProperties setTemplatePrefix(String templatePrefix) {
        this.templatePrefix = templatePrefix;
        return this;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public EmailProperties setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("templatePrefix", templatePrefix)
                .append("templateSuffix", templateSuffix)
                .toString();
    }
}
