package icu.d4peng.cloud.common.message.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> EmailProperties:邮件的配置属性
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = EmailProperties.PREFIX)
@EqualsAndHashCode(callSuper = true)
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
}
