package icu.d4peng.cloud.common.log.interceptor;//package icu.d4peng.cloud.common.log.interceptor;
//
//import icu.d4peng.cloud.common.log.bean.LogBean;
//import icu.d4peng.cloud.common.log.constant.LogConstant;
//import icu.d4peng.cloud.common.log.utils.LogUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2021-12-27 14:49
// * @description WebLogInterceptor: WEB日志拦截
// */
//public class WebLogInterceptor implements HandlerInterceptor {
//    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            // TODO
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//        }
//        // traceId
//        String traceId = request.getHeader(LogConstant.TRACE_ID.getName());
//        // spanId
//        String spanId = request.getHeader(LogConstant.SPAN_ID.getName());
//        // preAppName
//        String preApp = request.getHeader(LogConstant.PRE_APP.getName());
//        // preHost
//        String preHost = request.getHeader(LogConstant.PRE_HOST.getName());
//        // preIp
//        String preIp = request.getHeader(LogConstant.PRE_IP.getName());
//
//        LogBean logInfo = new LogBean()
//                .setTraceId(traceId).setSpanId(spanId)
//                .setPreIp(preIp).setPreApp(preApp)
//                .setPreHost(preHost);
//        LogUtil.preHandle(logInfo);
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        LogUtil.afterHandle();
//    }
//}
