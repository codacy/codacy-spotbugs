# [Weak SSLContext](https://find-sec-bugs.github.io/bugs.htm#SSL_CONTEXT)

    **Vulnerable Code:**  

<pre>SSLContext.getInstance("SSL");</pre>

**Solution:**  

Upgrade your implementation to the following, and configure `https.protocols` JVM option to include TLSv1.2:

<pre>SSLContext.getInstance("TLS");</pre>

**References**  

[Diagnosing TLS, SSL, and HTTPS](https://blogs.oracle.com/java-platform-group/entry/diagnosing_tls_ssl_and_https)