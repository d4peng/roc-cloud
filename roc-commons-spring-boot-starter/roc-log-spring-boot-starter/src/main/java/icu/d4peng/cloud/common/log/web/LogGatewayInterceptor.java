package icu.d4peng.cloud.common.log.web;

import icu.d4peng.cloud.common.core.util.NetUtils;
import icu.d4peng.cloud.common.log.constant.LogConstant;
import icu.d4peng.cloud.common.log.core.LogCore;
import icu.d4peng.cloud.common.log.msg.LogMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

/**
 * <p> LogGatewayInterceptor:网关拦截器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class LogGatewayInterceptor implements GlobalFilter, Ordered {
    private static final Integer FIRST = 0;

    @Value("${spring.application.name}")
    private String appName;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String traceId = null;
        String spanId = null;
        String preAppName = null;
        String preHost = null;
        String preIp = null;
        HttpHeaders headers = exchange.getRequest().getHeaders();
        List<String> traceIds = headers.get(LogConstant.TRACE_ID);
        if (traceIds != null && traceIds.size() > 0) {
            traceId = traceIds.get(FIRST);
        }
        List<String> spanIds = headers.get(LogConstant.SPAN_ID);
        if (spanIds != null && spanIds.size() > 0) {
            spanId = spanIds.get(FIRST);
        }
        List<String> preAppNames = headers.get(LogConstant.PRE_APP_NAME);
        if (preAppNames != null && preAppNames.size() > 0) {
            preAppName = preAppNames.get(FIRST);
        }
        List<String> preHosts = headers.get(LogConstant.PRE_HOST);
        if (preHosts != null && preHosts.size() > 0) {
            preHost = preHosts.get(FIRST);
        }
        List<String> preIps = headers.get(LogConstant.PRE_IP);
        if (preIps != null && preIps.size() > 0) {
            preIp = preIps.get(FIRST);
        }

        LogMsg logMsg = new LogMsg()
                .setTraceId(traceId)
                .setSpanId(spanId)
                .setPreAppName(preAppName)
                .setPreHost(preHost)
                .setPreIp(preIp);

        LogCore.before(logMsg);

        // 生成请求头
        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            httpHeader.set(LogConstant.TRACE_ID, logMsg.getTraceId());
            httpHeader.set(LogConstant.SPAN_ID, logMsg.getSpanId());
            httpHeader.set(LogConstant.PRE_APP_NAME, this.appName);
            httpHeader.set(LogConstant.PRE_HOST, NetUtils.getLocalHostName());
            httpHeader.set(LogConstant.PRE_IP, NetUtils.getLocalHostName());
        };
        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().headers(httpHeaders).build();
        exchange = exchange.mutate().request(serverHttpRequest).build();

        return chain.filter(exchange)
                .doFinally(signalType -> LogCore.after());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
