package icu.d4peng.cloud.common.http.properties;

import com.dtflys.forest.callback.AddressSource;
import com.dtflys.forest.callback.RetryWhen;
import com.dtflys.forest.callback.SuccessWhen;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.logging.ForestLogHandler;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.dtflys.forest.retryer.ForestRetryer;
import com.dtflys.forest.ssl.SSLUtils;
import icu.d4peng.cloud.common.http.config.RocLogHandler;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> HttpProperties:Http属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = HttpProperties.PREFIX)
public class HttpProperties {
    public static final String PREFIX = "roc.http";
    private boolean enabled = true;
    private String beanId = "forestConfiguration";
    private int maxConnections = 500;
    private int maxRouteConnections = 500;
    private int maxAsyncThreadSize = 100;
    private int timeout = 3000;
    private Integer connectTimeout = null;
    private Integer readTimeout = null;
    private String charset = "UTF-8";
    private String baseAddressScheme;
    private String baseAddressHost;
    private Integer baseAddressPort;
    private Class<? extends AddressSource> baseAddressSource;
    private Class<? extends ForestRetryer> retryer = BackOffRetryer.class;
    private Integer maxRetryCount = 0;
    private long maxRetryInterval = 0;
    private boolean autoRedirection = true;
    private boolean logEnabled = true;
    private boolean logRequest = true;
    private boolean logResponseStatus = true;
    private boolean logResponseContent = false;
    private Class<? extends ForestLogHandler> logHandler = RocLogHandler.class;
    private String sslProtocol = SSLUtils.TLS_1_2;
    private String backend = "okhttp3";
    private Map<String, Object> variables = new HashMap<>();
    private List<Class<? extends Interceptor<?>>> interceptors = new ArrayList<>();
    private Class<? extends SuccessWhen> successWhen;
    private Class<? extends RetryWhen> retryWhen;
    private List<HttpSslKeyStoreProperties> sslKeyStores = new ArrayList<>();
    private HttpConvertProperties converters = new HttpConvertProperties();
    private Map<String, Class<?>> filters = new HashMap<>();

    public boolean isEnabled() {
        return enabled;
    }

    public HttpProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getBeanId() {
        return beanId;
    }

    public HttpProperties setBeanId(String beanId) {
        this.beanId = beanId;
        return this;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public HttpProperties setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
        return this;
    }

    public int getMaxRouteConnections() {
        return maxRouteConnections;
    }

    public HttpProperties setMaxRouteConnections(int maxRouteConnections) {
        this.maxRouteConnections = maxRouteConnections;
        return this;
    }

    public int getMaxAsyncThreadSize() {
        return maxAsyncThreadSize;
    }

    public HttpProperties setMaxAsyncThreadSize(int maxAsyncThreadSize) {
        this.maxAsyncThreadSize = maxAsyncThreadSize;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public HttpProperties setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public HttpProperties setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public HttpProperties setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public HttpProperties setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getBaseAddressScheme() {
        return baseAddressScheme;
    }

    public HttpProperties setBaseAddressScheme(String baseAddressScheme) {
        this.baseAddressScheme = baseAddressScheme;
        return this;
    }

    public String getBaseAddressHost() {
        return baseAddressHost;
    }

    public HttpProperties setBaseAddressHost(String baseAddressHost) {
        this.baseAddressHost = baseAddressHost;
        return this;
    }

    public Integer getBaseAddressPort() {
        return baseAddressPort;
    }

    public HttpProperties setBaseAddressPort(Integer baseAddressPort) {
        this.baseAddressPort = baseAddressPort;
        return this;
    }

    public Class<? extends AddressSource> getBaseAddressSource() {
        return baseAddressSource;
    }

    public HttpProperties setBaseAddressSource(Class<? extends AddressSource> baseAddressSource) {
        this.baseAddressSource = baseAddressSource;
        return this;
    }

    public Class<? extends ForestRetryer> getRetryer() {
        return retryer;
    }

    public HttpProperties setRetryer(Class<? extends ForestRetryer> retryer) {
        this.retryer = retryer;
        return this;
    }

    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    public HttpProperties setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
        return this;
    }

    public long getMaxRetryInterval() {
        return maxRetryInterval;
    }

    public HttpProperties setMaxRetryInterval(long maxRetryInterval) {
        this.maxRetryInterval = maxRetryInterval;
        return this;
    }

    public boolean isAutoRedirection() {
        return autoRedirection;
    }

    public HttpProperties setAutoRedirection(boolean autoRedirection) {
        this.autoRedirection = autoRedirection;
        return this;
    }

    public boolean isLogEnabled() {
        return logEnabled;
    }

    public HttpProperties setLogEnabled(boolean logEnabled) {
        this.logEnabled = logEnabled;
        return this;
    }

    public boolean isLogRequest() {
        return logRequest;
    }

    public HttpProperties setLogRequest(boolean logRequest) {
        this.logRequest = logRequest;
        return this;
    }

    public boolean isLogResponseStatus() {
        return logResponseStatus;
    }

    public HttpProperties setLogResponseStatus(boolean logResponseStatus) {
        this.logResponseStatus = logResponseStatus;
        return this;
    }

    public boolean isLogResponseContent() {
        return logResponseContent;
    }

    public HttpProperties setLogResponseContent(boolean logResponseContent) {
        this.logResponseContent = logResponseContent;
        return this;
    }

    public Class<? extends ForestLogHandler> getLogHandler() {
        return logHandler;
    }

    public HttpProperties setLogHandler(Class<? extends ForestLogHandler> logHandler) {
        this.logHandler = logHandler;
        return this;
    }

    public String getSslProtocol() {
        return sslProtocol;
    }

    public HttpProperties setSslProtocol(String sslProtocol) {
        this.sslProtocol = sslProtocol;
        return this;
    }

    public String getBackend() {
        return backend;
    }

    public HttpProperties setBackend(String backend) {
        this.backend = backend;
        return this;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public HttpProperties setVariables(Map<String, Object> variables) {
        this.variables = variables;
        return this;
    }

    public List<Class<? extends Interceptor<?>>> getInterceptors() {
        return interceptors;
    }

    public HttpProperties setInterceptors(List<Class<? extends Interceptor<?>>> interceptors) {
        this.interceptors = interceptors;
        return this;
    }

    public Class<? extends SuccessWhen> getSuccessWhen() {
        return successWhen;
    }

    public HttpProperties setSuccessWhen(Class<? extends SuccessWhen> successWhen) {
        this.successWhen = successWhen;
        return this;
    }

    public Class<? extends RetryWhen> getRetryWhen() {
        return retryWhen;
    }

    public HttpProperties setRetryWhen(Class<? extends RetryWhen> retryWhen) {
        this.retryWhen = retryWhen;
        return this;
    }

    public List<HttpSslKeyStoreProperties> getSslKeyStores() {
        return sslKeyStores;
    }

    public HttpProperties setSslKeyStores(List<HttpSslKeyStoreProperties> sslKeyStores) {
        this.sslKeyStores = sslKeyStores;
        return this;
    }

    public HttpConvertProperties getConverters() {
        return converters;
    }

    public HttpProperties setConverters(HttpConvertProperties converters) {
        this.converters = converters;
        return this;
    }

    public Map<String, Class<?>> getFilters() {
        return filters;
    }

    public HttpProperties setFilters(Map<String, Class<?>> filters) {
        this.filters = filters;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("beanId", beanId)
                .append("maxConnections", maxConnections)
                .append("maxRouteConnections", maxRouteConnections)
                .append("maxAsyncThreadSize", maxAsyncThreadSize)
                .append("timeout", timeout)
                .append("connectTimeout", connectTimeout)
                .append("readTimeout", readTimeout)
                .append("charset", charset)
                .append("baseAddressScheme", baseAddressScheme)
                .append("baseAddressHost", baseAddressHost)
                .append("baseAddressPort", baseAddressPort)
                .append("baseAddressSource", baseAddressSource)
                .append("retryer", retryer)
                .append("maxRetryCount", maxRetryCount)
                .append("maxRetryInterval", maxRetryInterval)
                .append("autoRedirection", autoRedirection)
                .append("logEnabled", logEnabled)
                .append("logRequest", logRequest)
                .append("logResponseStatus", logResponseStatus)
                .append("logResponseContent", logResponseContent)
                .append("logHandler", logHandler)
                .append("sslProtocol", sslProtocol)
                .append("backend", backend)
                .append("variables", variables)
                .append("interceptors", interceptors)
                .append("successWhen", successWhen)
                .append("retryWhen", retryWhen)
                .append("sslKeyStores", sslKeyStores)
                .append("converters", converters)
                .append("filters", filters)
                .toString();
    }
}
