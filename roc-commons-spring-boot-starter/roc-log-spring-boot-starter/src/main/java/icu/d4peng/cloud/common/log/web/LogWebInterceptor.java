package icu.d4peng.cloud.common.log.web;

import icu.d4peng.cloud.common.log.constant.LogConstant;
import icu.d4peng.cloud.common.log.core.LogCore;
import icu.d4peng.cloud.common.log.msg.LogMsg;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-23 20:14
 * @description LogWebInterceptor:web拦截器
 */
public class LogWebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            String traceId = request.getHeader(LogConstant.TRACE_ID);
            String spanId = request.getHeader(LogConstant.SPAN_ID);
            String preAppName = request.getHeader(LogConstant.PRE_APP_NAME);
            String preHost = request.getHeader(LogConstant.PRE_HOST);
            String preIp = request.getHeader(LogConstant.PRE_IP);

            LogMsg logMsg = new LogMsg()
                    .setTraceId(traceId)
                    .setSpanId(spanId)
                    .setPreAppName(preAppName)
                    .setPreHost(preHost)
                    .setPreIp(preIp);

            LogCore.before(logMsg);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LogCore.after();
    }
}
