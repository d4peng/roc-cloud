package icu.d4peng.cloud.common.log.msg;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * <p> LogMsg:Log信息存储
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
@Accessors(chain = true)
public class LogMsg implements Serializable {
    /**
     * 轨迹ID:一次请求中,traceId是唯一的
     */
    private String traceId;
    /**
     * 跨度ID:经过一个服务,spanID就会分裂一次
     */
    private String spanId;
    /**
     * 上游App名称
     */
    private String preAppName;
    /**
     * 上游主机名
     */
    private String preHost;
    /**
     * 上游IP
     */
    private String preIp;
    /**
     * 扩展信息
     */
    private Map<String, Object> extData;
}
