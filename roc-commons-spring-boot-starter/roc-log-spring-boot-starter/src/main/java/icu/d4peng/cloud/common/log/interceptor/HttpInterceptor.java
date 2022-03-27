package icu.d4peng.cloud.common.log.interceptor;//package icu.d4peng.cloud.common.log.interceptor;
//
//import com.dtflys.forest.http.ForestRequest;
//import com.dtflys.forest.interceptor.Interceptor;
//import icu.d4peng.cloud.common.core.util.SpringIocUtils;
//import icu.d4peng.cloud.common.log.constant.LogConstant;
//import icu.d4peng.cloud.common.log.context.LogContext;
//import icu.d4peng.cloud.common.log.generator.spanid.DefaultSpanIdGenerator;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2022-03-20 20:16
// * @description HttpInterceptor:Http拦截器添加请求
// */
//public class HttpInterceptor implements Interceptor<Object> {
//    private final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);
//
//    @Override
//    public boolean beforeExecute(ForestRequest request) {
//        String traceId = LogContext.getTraceId();
//        if (StringUtils.isNotBlank(traceId)) {
//            request.addHeader(LogConstant.TRACE_ID.getName(), traceId);
//            request.addHeader(LogConstant.SPAN_ID.getName(), new DefaultSpanIdGenerator().generateNextSpanId());
//            request.addHeader(LogConstant.PRE_APP.getName(), SpringIocUtils.getEnvironmentProperty("spring.application.name"));
//            request.addHeader(LogConstant.PRE_HOST.getName(), "LocalhostUtil.getHostName()");
//            request.addHeader(LogConstant.PRE_IP.getName(), "LocalhostUtil.getHostIp()");
//        } else {
//            LOGGER.debug("本地threadLocal变量没有正确传递traceId,本次调用不传递traceId");
//        }
//        return true;
//    }
//}