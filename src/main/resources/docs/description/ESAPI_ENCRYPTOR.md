# [Use of ESAPI Encryptor](https://find-sec-bugs.github.io/bugs.htm#ESAPI_ENCRYPTOR)

    The ESAPI has a small history of vulnerabilities within the cryptography component. Here is a quick validation list to
    make sure the Authenticated Encryption is working as expected.

**1\. Library Version**

    This issue is corrected in ESAPI version 2.1.0\. Versions <= 2.0.1 are vulnerable to a MAC bypass (CVE-2013-5679).  

    For Maven users, the plugin [versions](https://www.mojohaus.org/versions-maven-plugin/) can be called using the
    following command. The effective version of ESAPI will be available in the output.  

<pre>$ mvn versions:display-dependency-updates</pre>

Output:  

<pre>
[...]
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.slf4j:slf4j-api ................................... 1.6.4 -&gt; 1.7.7
[INFO]   org.owasp.esapi:esapi ................................. 2.0.1 -&gt; 2.1.0
[...]
    </pre>

    or by looking at the configuration directly.  

<pre>

 <dependency>

  <groupid>
   org.owasp.esapi 
   <artifactid>
    esapi 
    <version>
     2.1.0
    </version> 
   </artifactid>
  </groupid>
 </dependency></pre>

    For Ant users, the jar used should be [esapi-2.1.0.jar](https://repo1.maven.org/maven2/org/owasp/esapi/esapi/2.1.0/esapi-2.1.0.jar).

**2\. Configuration:**

    The library version 2.1.0 is still vulnerable to key size being changed in the ciphertext definition (CVE-2013-5960). Some precautions need to be taken.  

<div>
 **The cryptographic configuration of ESAPI can also be vulnerable if any of these elements are present:** **Insecure configuration:** 
 <pre>
Encryptor.CipherText.useMAC=false

Encryptor.EncryptionAlgorithm=AES
Encryptor.CipherTransformation=AES/CBC/PKCS5Padding

Encryptor.cipher_modes.additional_allowed=CBC</pre> 
</div>

<div>
  **Secure configuration:** 
 <pre>
#Needed
Encryptor.CipherText.useMAC=true

#Needed to have a solid auth. encryption
Encryptor.EncryptionAlgorithm=AES
Encryptor.CipherTransformation=AES/GCM/NoPadding

#CBC mode should be removed to avoid padding oracle
Encryptor.cipher_modes.additional_allowed=</pre> 
</div>

    **References**  

    [ESAPI Security bulletin 1 (CVE-2013-5679)](https://github.com/peval/owasp-esapi-java/blob/master/documentation/ESAPI-security-bulletin1.pdf)  

    [Vulnerability Summary for CVE-2013-5679](https://nvd.nist.gov/vuln/detail/CVE-2013-5679)  

    [Synactiv: Bypassing HMAC validation in OWASP ESAPI symmetric encryption](https://www.synacktiv.com/ressources/synacktiv_owasp_esapi_hmac_bypass.pdf)  

    [CWE-310: Cryptographic Issues](https://cwe.mitre.org/data/definitions/310.html)  

    [ESAPI-dev mailing list: Status of CVE-2013-5960](https://lists.owasp.org/pipermail/esapi-dev/2015-March/002533)