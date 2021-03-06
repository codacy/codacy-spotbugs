# [SHA-1 is a weak hash function](https://find-sec-bugs.github.io/bugs.htm#WEAK_MESSAGE_DIGEST_SHA1)

The algorithms SHA-1 is not a recommended algorithm for hash password, for signature verification and other
uses. **PBKDF2** should be used to hash password for example.

> "**SHA-1 for digital signature generation:**  
> 
>     SHA-1 may only be used for digital signature generation where specifically allowed by NIST protocol-specific guidance.
>     For all other applications, <u>SHA-1 shall not be used for digital signature generation</u>.  
> 
>     **SHA-1 for digital signature verification:**  
> 
>     For digital signature verification, <u>SHA-1 is allowed for legacy-use</u>.  
> 
>     [...]  
> 
>     **SHA-224, SHA-256, SHA-384, SHA-512, SHA-512/224, and SHA-512/256**:  
> 
>     The use of these hash functions is acceptable for all hash function applications."  
> 
>     - [NIST: Transitioning the Use of Cryptographic Algorithms and Key Lengths p.15](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-131Ar2.pdf)

> "The main idea of a PBKDF is to slow dictionary or brute force attacks on the passwords by increasing the time
>     needed to test each password. An attacker with a list of likely passwords can evaluate the PBKDF using the known
>     iteration counter and the salt. Since an attacker has to spend a significant amount of computing time for each try,
>     it becomes harder to apply the dictionary or brute force attacks."  
> 
> - [NIST: Recommendation for Password-Based Key Derivation  p.12](https://nvlpubs.nist.gov/nistpubs/Legacy/SP/nistspecialpublication800-132.pdf)

    **Vulnerable Code:**  

<pre>MessageDigest sha1Digest = MessageDigest.getInstance("SHA1");
    sha1Digest.update(password.getBytes());
    byte[] hashValue = sha1Digest.digest();</pre>

<pre>byte[] hashValue = DigestUtils.getSha1Digest().digest(password.getBytes());</pre>

    **Solution (Using bouncy castle):**  

<pre>public static byte[] getEncryptedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());
    gen.init(password.getBytes("UTF-8"), salt.getBytes(), 4096);
    return ((KeyParameter) gen.generateDerivedParameters(256)).getKey();
}</pre>

    **Solution (Java 8 and later):**  

<pre>public static byte[] getEncryptedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 4096, 256 * 8);
    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    return f.generateSecret(spec).getEncoded();
}</pre>

**References**  

[Qualys blog: SHA1 Deprecation: What You Need to Know](https://community.qualys.com/blogs/securitylabs/2014/09/09/sha1-deprecation-what-you-need-to-know)  

[Google Online Security Blog: Gradually sunsetting SHA-1](https://googleonlinesecurity.blogspot.ca/2014/09/gradually-sunsetting-sha-1.html)  

[NIST: Transitioning the Use of Cryptographic Algorithms and Key Lengths](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-131Ar2.pdf)  

[NIST: Recommendation for Password-Based Key Derivation](https://nvlpubs.nist.gov/nistpubs/Legacy/SP/nistspecialpublication800-132.pdf)  

[Stackoverflow: Reliable implementation of PBKDF2-HMAC-SHA256 for Java](https://stackoverflow.com/q/22580853/89769)  

[CWE-327: Use of a Broken or Risky Cryptographic Algorithm](https://cwe.mitre.org/data/definitions/327.html)