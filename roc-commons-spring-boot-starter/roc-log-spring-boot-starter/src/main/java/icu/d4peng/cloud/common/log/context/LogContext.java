package icu.d4peng.cloud.common.log.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:09
 * @description LogContext:日志上下文记录
 */
public class LogContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogContext.class);
    /**
     * TraceId上下文
     */
    private static final ThreadLocal<String> TRACE_ID = new TransmittableThreadLocal<String>();
    /**
     * SpanId上下文
     */
    private static final ThreadLocal<String> SPAN_ID = new TransmittableThreadLocal<String>();
    /**
     * 当前IP上下文
     */
    private static final ThreadLocal<String> CURRENT_IP = new TransmittableThreadLocal<String>();
    /**
     * 上游APP上下文
     */
    private static final ThreadLocal<String> PRE_APP_NAME = new TransmittableThreadLocal<String>();
    /**
     * 上游主机上下文
     */
    private static final ThreadLocal<String> PRE_HOST = new TransmittableThreadLocal<String>();
    /**
     * 上游IP上下文
     */
    private static final ThreadLocal<String> PRE_IP = new TransmittableThreadLocal<String>();


    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void putTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static void removeTraceId() {
        TRACE_ID.remove();
    }

    public static String getSpanId() {
        return SPAN_ID.get();
    }

    public static void putSpanId(String spanId) {
        SPAN_ID.set(spanId);
    }

    public static void removeSpanId() {
        SPAN_ID.remove();
    }

    public static String getPreAppName() {
        return PRE_APP_NAME.get();
    }

    public static void putPreAppName(String preApp) {
        PRE_APP_NAME.set(preApp);
    }

    public static void removePreAppName() {
        PRE_APP_NAME.remove();
    }

    public static String getPreHost() {
        return PRE_HOST.get();
    }

    public static void putPreHost(String preHost) {
        PRE_HOST.set(preHost);
    }

    public static void removePreHost() {
        PRE_HOST.remove();
    }

    public static String getPreIP() {
        return PRE_IP.get();
    }

    public static void putPreIP(String preIP) {
        PRE_IP.set(preIP);
    }

    public static void removePreIP() {
        PRE_IP.remove();
    }

    public static String getCurrentIP() {
        return CURRENT_IP.get();
    }

    public static void putCurrentIP(String currentIP) {
        CURRENT_IP.set(currentIP);
    }

    public static void removeCurrentIP() {
        CURRENT_IP.remove();
    }

}
