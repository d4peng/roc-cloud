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
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-21 21:09
 * @description LogCore:Log的核心类
 */
public class LogCore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogCore.class);

    /**
     * 开始:这里存放的是服务进来时的上下文信息
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
        LogContext.putCurrentIP(NetUtils.getLocalIP());

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
        LogContext.putPreIP(logMsg.getPreIp());

        String label = LogGenerator.generateLogLabel(LogContext.getTraceId(), LogContext.getSpanId(),
                LogContext.getCurrentIP(), LogContext.getPreAppName(), LogContext.getPreHost(),
                LogContext.getPreIP());

        // 放入到MDC
        MDC.put(LogConstant.MDC, label);
    }

    /**
     * 进行中
     */
    public  void process() {

    }

    /**
     * 结束
     */
    public static void after() {
        LogContext.removeTraceId();
        LogContext.removeSpanId();
        LogContext.removeCurrentIP();
        LogContext.removePreAppName();
        LogContext.removePreHost();
        LogContext.removePreIP();
    }

}
