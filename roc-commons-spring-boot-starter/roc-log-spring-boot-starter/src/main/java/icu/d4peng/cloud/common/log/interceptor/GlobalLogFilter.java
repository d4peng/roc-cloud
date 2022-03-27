package icu.d4peng.cloud.common.log.interceptor;//package icu.d4peng.cloud.common.log.interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2022-03-20 20:29
// * @description GlobalLogFilter:全局过滤器
// */
//public class GlobalLogFilter implements GlobalFilter, Ordered {
//    @Value("${spring.application.name}")
//    private String appName;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalLogFilter.class);
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return chain.filter(TLogWebFluxCommon.loadInstance().preHandle(exchange, appName))
//                .doFinally(signalType -> TLogWebFluxCommon.loadInstance().cleanThreadLocal());
//    }
//
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//}
