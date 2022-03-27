package icu.d4peng.cloud.common.http.properties;

import com.dtflys.forest.callback.AddressSource;
import com.dtflys.forest.callback.RetryWhen;
import com.dtflys.forest.callback.SuccessWhen;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.logging.DefaultLogHandler;
import com.dtflys.forest.logging.ForestLogHandler;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.dtflys.forest.retryer.ForestRetryer;
import com.dtflys.forest.ssl.SSLUtils;
import icu.d4peng.cloud.common.http.config.RocLogHandler;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
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
    private List<HttpSSLKeyStoreProperties> sslKeyStores = new ArrayList<>();
    private HttpConvertProperties converters = new HttpConvertProperties();
    private Map<String, Class<?>> filters = new HashMap<>();
}
