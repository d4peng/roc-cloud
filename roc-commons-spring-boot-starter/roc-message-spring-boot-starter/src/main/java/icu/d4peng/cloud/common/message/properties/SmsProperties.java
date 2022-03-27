package icu.d4peng.cloud.common.message.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> SmsProperties:阿里云短信配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
@Accessors(chain = true)
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

}
