package icu.d4peng.cloud.common.message.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 15:40
 * @description EmailProperties:邮件的配置属性
 */
@Data
@Accessors(chain = true)
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
}
