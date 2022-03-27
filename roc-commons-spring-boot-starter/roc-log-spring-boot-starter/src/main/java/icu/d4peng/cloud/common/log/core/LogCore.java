package icu.d4peng.cloud.common.log.core;

import icu.d4peng.cloud.common.core.util.NetUtils;
import icu.d4peng.cloud.common.log.constant.LogConstant;
import icu.d4peng.cloud.common.log.context.LogContext;
import icu.d4peng.cloud.common.log.generator.LogGenerator;
import icu.d4peng.cloud.common.log.msg.LogMsg;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * <p> LogCore:Log的核心类
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class LogCore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogCore.class);

    /**
     * 这里存放的是服务进来时的上下文信息
     *
     * @param logMsg 信息
     */
    public static void before(LogMsg logMsg) {
        // 第一次不存在,就需要生成,网关处生成
        if (StringUtils.isBlank(logMsg.getTraceId())) {
            // 如果没有traceId,就生成
            String traceId = LogGenerator.generatorTraceId();
            logMsg.setTraceId(traceId);
        }
        LogContext.putTraceId(logMsg.getTraceId());

        // 空的话就先生成,不为空就需要依据规则分裂
        if (StringUtils.isBlank(logMsg.getSpanId())) {
            String spanId = LogGenerator.generatorSpanId(logMsg.getSpanId());
            logMsg.setSpanId(spanId);
        }
        LogContext.putSpanId(logMsg.getSpanId());

        // 当前IP
        LogContext.putCurrentIp(NetUtils.getLocalIp());

        // 上游服务名称
        if (StringUtils.isBlank(logMsg.getPreAppName())) {
            logMsg.setPreAppName(LogConstant.NONE);
        }
        LogContext.putPreAppName(logMsg.getPreAppName());

        // 上游主机名称
        if (StringUtils.isBlank(logMsg.getPreHost())) {
            logMsg.setPreHost(LogConstant.NONE);
        }
        LogContext.putPreHost(logMsg.getPreHost());

        // 上游IP
        if (StringUtils.isBlank(logMsg.getPreIp())) {
            logMsg.setPreIp(LogConstant.NONE);
        }
        LogContext.putPreIp(logMsg.getPreIp());

        String label = LogGenerator.generateLogLabel(LogContext.getTraceId(), LogContext.getSpanId(),
                LogContext.getCurrentIp(), LogContext.getPreAppName(), LogContext.getPreHost(),
                LogContext.getPreIp());

        // 放入到MDC
        MDC.put(LogConstant.MDC, label);
    }

    /**
     * 结束
     */
    public static void after() {
        LogContext.removeTraceId();
        LogContext.removeSpanId();
        LogContext.removeCurrentIp();
        LogContext.removePreAppName();
        LogContext.removePreHost();
        LogContext.removePreIp();
    }

    /**
     * 进行中
     */
    public void process() {

    }

}
