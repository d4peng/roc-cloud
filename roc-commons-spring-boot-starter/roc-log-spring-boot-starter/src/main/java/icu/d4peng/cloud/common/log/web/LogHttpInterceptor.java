package icu.d4peng.cloud.common.log.web;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import icu.d4peng.cloud.common.core.util.NetUtils;
import icu.d4peng.cloud.common.core.util.SpringAware;
import icu.d4peng.cloud.common.log.constant.LogConstant;
import icu.d4peng.cloud.common.log.context.LogContext;
import icu.d4peng.cloud.common.log.generator.LogGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> LogHttpInterceptor:Http时引用
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class LogHttpInterceptor implements Interceptor<Object> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean beforeExecute(ForestRequest request) {
        String traceId = LogContext.getTraceId();
        if (StringUtils.isNotBlank(traceId)) {
            String appName = SpringAware.getEnvironmentProperty("spring.application.name");

            request.addHeader(LogConstant.TRACE_ID, traceId);
            request.addHeader(LogConstant.SPAN_ID, LogGenerator.generatorSpanId(LogContext.getSpanId()));
            request.addHeader(LogConstant.PRE_APP_NAME, appName);
            request.addHeader(LogConstant.PRE_HOST, NetUtils.getLocalHostName());
            request.addHeader(LogConstant.PRE_IP, NetUtils.getLocalIp());
        } else {
            log.debug("[TLOG]本地threadLocal变量没有正确传递traceId,本次调用不传递traceId");
        }
        return true;
    }
}
