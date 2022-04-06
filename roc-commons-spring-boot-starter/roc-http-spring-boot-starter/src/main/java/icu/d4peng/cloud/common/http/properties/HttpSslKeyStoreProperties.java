package icu.d4peng.cloud.common.http.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.security.KeyStore;

/**
 * <p> HttpSSLKeyStoreProperties:Http密钥链接
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
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

    public String getId() {
        return id;
    }

    public HttpSslKeyStoreProperties setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public HttpSslKeyStoreProperties setType(String type) {
        this.type = type;
        return this;
    }

    public String getFile() {
        return file;
    }

    public HttpSslKeyStoreProperties setFile(String file) {
        this.file = file;
        return this;
    }

    public String getKeystorePass() {
        return keystorePass;
    }

    public HttpSslKeyStoreProperties setKeystorePass(String keystorePass) {
        this.keystorePass = keystorePass;
        return this;
    }

    public String getCertPass() {
        return certPass;
    }

    public HttpSslKeyStoreProperties setCertPass(String certPass) {
        this.certPass = certPass;
        return this;
    }

    public KeyStore getTrustStore() {
        return trustStore;
    }

    public HttpSslKeyStoreProperties setTrustStore(KeyStore trustStore) {
        this.trustStore = trustStore;
        return this;
    }

    public String getProtocols() {
        return protocols;
    }

    public HttpSslKeyStoreProperties setProtocols(String protocols) {
        this.protocols = protocols;
        return this;
    }

    public String getCipherSuites() {
        return cipherSuites;
    }

    public HttpSslKeyStoreProperties setCipherSuites(String cipherSuites) {
        this.cipherSuites = cipherSuites;
        return this;
    }

    public String getHostnameVerifier() {
        return hostnameVerifier;
    }

    public HttpSslKeyStoreProperties setHostnameVerifier(String hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public String getSslSocketFactoryBuilder() {
        return sslSocketFactoryBuilder;
    }

    public HttpSslKeyStoreProperties setSslSocketFactoryBuilder(String sslSocketFactoryBuilder) {
        this.sslSocketFactoryBuilder = sslSocketFactoryBuilder;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("type", type)
                .append("file", file)
                .append("keystorePass", keystorePass)
                .append("certPass", certPass)
                .append("trustStore", trustStore)
                .append("protocols", protocols)
                .append("cipherSuites", cipherSuites)
                .append("hostnameVerifier", hostnameVerifier)
                .append("sslSocketFactoryBuilder", sslSocketFactoryBuilder)
                .toString();
    }
}
