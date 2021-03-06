# [Hard coded key](https://find-sec-bugs.github.io/bugs.htm#HARD_CODE_KEY)

Cryptographic keys should not be kept in the source code. The source code can be widely shared in an enterprise environment, and is
certainly shared in open source. To be managed safely, passwords and secret keys should be stored in separate configuration files or keystores.
(Hard coded passwords are reported separately by the _Hard coded password_ pattern)

**Vulnerable Code:**  

<pre>byte[] key = {1, 2, 3, 4, 5, 6, 7, 8};
SecretKeySpec spec = new SecretKeySpec(key, "AES");
Cipher aes = Cipher.getInstance("AES");
aes.init(Cipher.ENCRYPT_MODE, spec);
return aesCipher.doFinal(secretData);</pre>

**References**  

[CWE-321: Use of Hard-coded Cryptographic Key](https://cwe.mitre.org/data/definitions/321.html)