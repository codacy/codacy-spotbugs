# [DESede is insecure](https://find-sec-bugs.github.io/bugs.htm#TDES_USAGE)

Triple DES (also known as 3DES or DESede) is considered strong ciphers for modern applications. Currently, NIST recommends the
usage of AES block ciphers instead of 3DES.

    **Example weak code:**

<pre>Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
c.init(Cipher.ENCRYPT_MODE, k, iv);
byte[] cipherText = c.doFinal(plainText);</pre>

    **Example solution:**

<pre>Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
c.init(Cipher.ENCRYPT_MODE, k, iv);
byte[] cipherText = c.doFinal(plainText);</pre>

**References**  

[NIST Withdraws Outdated Data Encryption Standard](https://www.nist.gov/news-events/news/2005/06/nist-withdraws-outdated-data-encryption-standard)  

[CWE-326: Inadequate Encryption Strength](https://cwe.mitre.org/data/definitions/326.html)