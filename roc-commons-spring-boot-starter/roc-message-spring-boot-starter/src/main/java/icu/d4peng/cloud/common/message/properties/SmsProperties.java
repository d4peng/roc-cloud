package icu.d4peng.cloud.common.message.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-19 15:16
 * @description SmsProperties:阿里云短信配置
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
