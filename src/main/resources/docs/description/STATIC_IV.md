# [Static IV](https://find-sec-bugs.github.io/bugs.htm#STATIC_IV)

    Initialization vector must be regenerated for each message to be encrypted.

**Vulnerable Code:**

<pre>
private static byte[] IV = new byte[16] {(byte)0,(byte)1,(byte)2,[...]};

public void encrypt(String message) throws Exception {

    IvParameterSpec ivSpec = new IvParameterSpec(IV);
[...]
</pre>

**Solution:**

<pre>
public void encrypt(String message) throws Exception {

    byte[] iv = new byte[16];
    new SecureRandom().nextBytes(iv);

    IvParameterSpec ivSpec = new IvParameterSpec(iv);
[...]
</pre>

**References**  

[Wikipedia: Initialization vector](https://en.wikipedia.org/wiki/Initialization_vector)  

[CWE-329: Not Using a Random IV with CBC Mode](https://cwe.mitre.org/data/definitions/329.html)  

[Encryption - CBC Mode IV: Secret or Not?](https://defuse.ca/cbcmodeiv.htm)