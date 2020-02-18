# [Cipher is susceptible to Padding Oracle](https://find-sec-bugs.github.io/bugs.htm#PADDING_ORACLE)

    This specific mode of CBC with PKCS5Padding is susceptible to padding oracle attacks. An adversary could potentially decrypt the
    message if the system exposed the difference between plaintext with invalid padding or valid padding. The distinction between
    valid and invalid padding is usually revealed through distinct error messages being returned for each condition.

    **Code at risk:**

<pre>Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
c.init(Cipher.ENCRYPT_MODE, k, iv);
byte[] cipherText = c.doFinal(plainText);</pre>

    **Solution:**

<pre>Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
c.init(Cipher.ENCRYPT_MODE, k, iv);
byte[] cipherText = c.doFinal(plainText);</pre>

    **References**  

    [Padding Oracles for the masses (by Matias Soler)](http://www.infobytesec.com/down/paddingoracle_openjam.pdf)  

    [Wikipedia: Authenticated encryption](https://en.wikipedia.org/wiki/Authenticated_encryption)  

    [NIST: Authenticated Encryption Modes](https://csrc.nist.gov/projects/block-cipher-techniques/bcm/modes-develoment#01)  

    [CAPEC: Padding Oracle Crypto Attack](https://capec.mitre.org/data/definitions/463.html)  

    [CWE-696: Incorrect Behavior Order](https://cwe.mitre.org/data/definitions/696.html)