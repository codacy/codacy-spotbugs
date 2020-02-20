# [Blowfish usage with short key](https://find-sec-bugs.github.io/bugs.htm#BLOWFISH_KEY_SIZE)

The Blowfish cipher supports key sizes from 32 bits to 448 bits. A small key size makes the ciphertext vulnerable to brute force attacks.
At least 128 bits of entropy should be used when generating the key if use of Blowfish is required.

If the algorithm can be changed, the AES block cipher should be used instead.

**Vulnerable Code:**  

<pre>KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
keyGen.init(64);</pre>

**Solution:**  

<pre>KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
keyGen.init(128);</pre>

**References**  

[Blowfish (cipher)](https://en.wikipedia.org/wiki/Blowfish_(cipher))  

[CWE-326: Inadequate Encryption Strength](https://cwe.mitre.org/data/definitions/326.html)