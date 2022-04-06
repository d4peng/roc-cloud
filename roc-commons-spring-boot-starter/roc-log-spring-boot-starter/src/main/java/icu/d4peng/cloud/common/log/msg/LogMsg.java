package icu.d4peng.cloud.common.log.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * <p> LogMsg:Log信息存储
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
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

    public String getTraceId() {
        return traceId;
    }

    public LogMsg setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public String getSpanId() {
        return spanId;
    }

    public LogMsg setSpanId(String spanId) {
        this.spanId = spanId;
        return this;
    }

    public String getPreAppName() {
        return preAppName;
    }

    public LogMsg setPreAppName(String preAppName) {
        this.preAppName = preAppName;
        return this;
    }

    public String getPreHost() {
        return preHost;
    }

    public LogMsg setPreHost(String preHost) {
        this.preHost = preHost;
        return this;
    }

    public String getPreIp() {
        return preIp;
    }

    public LogMsg setPreIp(String preIp) {
        this.preIp = preIp;
        return this;
    }

    public Map<String, Object> getExtData() {
        return extData;
    }

    public LogMsg setExtData(Map<String, Object> extData) {
        this.extData = extData;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("traceId", traceId)
                .append("spanId", spanId)
                .append("preAppName", preAppName)
                .append("preHost", preHost)
                .append("preIp", preIp)
                .append("extData", extData)
                .toString();
    }
}
