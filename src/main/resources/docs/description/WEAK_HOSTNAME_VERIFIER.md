# [HostnameVerifier that accept any signed certificates](https://find-sec-bugs.github.io/bugs.htm#WEAK_HOSTNAME_VERIFIER)

A `HostnameVerifier` that accept any host are often use because of certificate reuse on many hosts.
As a consequence, this is vulnerable to
[Man-in-the-middle attacks](https://en.wikipedia.org/wiki/Man-in-the-middle_attack)
since the client will trust any certificate.

A TrustManager allowing specific certificates (based on a truststore for example) should be built.
Wildcard certificates should be created for reused on multiples subdomains.
Detailed information for a proper implementation is available at:
[[1]](https://stackoverflow.com/a/6378872/89769)
[[2]](https://stackoverflow.com/a/5493452/89769)

    **Vulnerable Code:**  

<pre>public class AllHosts implements HostnameVerifier {
    public boolean verify(final String hostname, final SSLSession session) {
        return true;
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