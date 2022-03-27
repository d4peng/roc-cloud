package icu.d4peng.cloud.common.http.properties;

import lombok.Data;

import java.security.KeyStore;

@Data
public class HttpSSLKeyStoreProperties {
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
