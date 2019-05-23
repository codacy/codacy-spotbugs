# [RSA with no padding is insecure](http://find-sec-bugs.github.io/bugs.htm#RSA_NO_PADDING)

The software uses the RSA algorithm but does not incorporate Optimal Asymmetric Encryption Padding (OAEP), which might weaken the encryption.

**Vulnerable Code:**  

<pre>Cipher.getInstance("RSA/NONE/NoPadding")</pre>

**Solution:**  

The code should be replaced with:  

<pre>Cipher.getInstance("RSA/ECB/OAEPWithMD5AndMGF1Padding")</pre>

**References**  

[CWE-780: Use of RSA Algorithm without OAEP](http://cwe.mitre.org/data/definitions/780.html)  

[Root Labs: Why RSA encryption padding is critical](http://rdist.root.org/2009/10/06/why-rsa-encryption-padding-is-critical/)