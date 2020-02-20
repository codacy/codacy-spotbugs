# [TrustManager that accept any certificates](https://find-sec-bugs.github.io/bugs.htm#WEAK_TRUST_MANAGER)

Empty TrustManager implementations are often used to connect easily to a host that is not signed by a root
[certificate authority](https://en.wikipedia.org/wiki/Certificate_authority). As a consequence, this is vulnerable to
[Man-in-the-middle attacks](https://en.wikipedia.org/wiki/Man-in-the-middle_attack)
since the client will trust any certificate.

A TrustManager allowing specific certificates (based on a TrustStore for example) should be built.
Detailed information for a proper implementation is available at:
[[1]](https://stackoverflow.com/a/6378872/89769)
[[2]](https://stackoverflow.com/a/5493452/89769)

    **Vulnerable Code:**  

<pre>class TrustAllManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        //Trust any client connecting (no certificate validation)
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        //Trust any remote server (no certificate validation)
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}</pre>

    **Solution (TrustMangager based on a keystore):**  

<pre>KeyStore ks = //Load keystore containing the certificates trusted

SSLContext sc = SSLContext.getInstance("TLS");

TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
tmf.init(ks);

sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),null);
</pre>

**References**  

[WASC-04: Insufficient Transport Layer Protection](http://projects.webappsec.org/w/page/13246945/Insufficient%20Transport%20Layer%20Protection)  

[CWE-295: Improper Certificate Validation](https://cwe.mitre.org/data/definitions/295.html)