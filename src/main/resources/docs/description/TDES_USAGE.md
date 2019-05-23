# [DESede is insecure](http://find-sec-bugs.github.io/bugs.htm#TDES_USAGE)

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

[NIST Withdraws Outdated Data Encryption Standard](http://www.nist.gov/itl/fips/060205_des.cfm)  

[CWE-326: Inadequate Encryption Strength](http://cwe.mitre.org/data/definitions/326.html)