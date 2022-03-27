package icu.d4peng.cloud.common.http.properties;

import lombok.Data;

import java.security.KeyStore;

/**
 * <p> HttpSSLKeyStoreProperties:Http密钥链接
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
public class HttpSslKeyStoreProperties {
    protected String id;
    protected String type = "jks";
    protected String file;
    protected String keystorePass;
    protected String certPass;
    protected KeyStore trustStore;
    protected String protocols;
    protected String cipherSuites;
    protected String hostnameVerifier;
    protected String sslSocketFactoryBuilder;
}
