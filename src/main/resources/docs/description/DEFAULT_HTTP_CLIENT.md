# [DefaultHttpClient with default constructor is not compatible with TLS 1.2](http://find-sec-bugs.github.io/bugs.htm#DEFAULT_HTTP_CLIENT)

    **Vulnerable Code:**  

<pre>HttpClient client = new DefaultHttpClient();</pre>

**Solution:**  

Upgrade your implementation to use one of the recommended constructs and configure `https.protocols` JVM option to include TLSv1.2:

*   Use [SystemDefaultHttpClient](http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/SystemDefaultHttpClient.html) instead
*   Create an HttpClient based on SSLSocketFactory - get an SSLScoketFactory instance with [`getSystemSocketFactory()`](https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/conn/ssl/SSLSocketFactory.html#getSystemSocketFactory()) and use this instance for HttpClient creation
*   Create an HttpClient based on SSLConnectionSocketFactory - get an instance with [`getSystemSocketFactory()`](https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/conn/ssl/SSLConnectionSocketFactory.html#getSystemSocketFactory()) and use this instance for HttpClient creation
*   Use HttpClientBuilder - call [`useSystemProperties()`](http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html#useSystemProperties()) before calling `build()`
*   HttpClients - call [`createSystem()`](https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClients.html#createSystem()) to create an instance

**References**  

[Diagnosing TLS, SSL, and HTTPS](https://blogs.oracle.com/java-platform-group/entry/diagnosing_tls_ssl_and_https)