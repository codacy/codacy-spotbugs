# [RSA usage with short key](https://find-sec-bugs.github.io/bugs.htm#RSA_KEY_SIZE)

    The NIST recommends the use of <u>2048 bits and higher</u> keys for the RSA algorithm.

> "Digital Signature Verification | RSA: `1024 ≤ len(n) < 2048` | Legacy-use"  
> 
>     "Digital Signature Verification | RSA: `len(n) ≥ 2048` | Acceptable"  
> 
>     - [NIST: Recommendation for Transitioning the Use of Cryptographic Algorithms and Key Lengths p.7](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-131Ar2.pdf)

**Vulnerable Code:**  

<pre>
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(512);
</pre>

**Solution:**  

The KeyPairGenerator creation should be as follows with at least 2048 bit key size.  

<pre>
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(2048);
</pre>

**References**  

[NIST: Latest publication on key management](https://csrc.nist.gov/projects/key-management)  

[NIST: Recommendation for Transitioning the Use of Cryptographic Algorithms and Key Lengths p.7](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-131Ar2.pdf)  

[Wikipedia: Asymmetric algorithm key lengths](https://en.wikipedia.org/wiki/Key_size#Asymmetric%5Falgorithm%5Fkey%5Flengths)  

[CWE-326: Inadequate Encryption Strength](https://cwe.mitre.org/data/definitions/326.html)  

[Keylength.com (BlueKrypt): Aggregate key length recommendations.](https://www.keylength.com/en/compare/)