# [Hazelcast symmetric encryption](https://find-sec-bugs.github.io/bugs.htm#HAZELCAST_SYMMETRIC_ENCRYPTION)

The network communications for Hazelcast is configured to use a symmetric cipher (probably DES or Blowfish).

Those ciphers alone do not provide integrity or secure authentication. The use of asymmetric encryption is preferred.

**References**  

[WASC-04: Insufficient Transport Layer Protection](http://projects.webappsec.org/w/page/13246945/Insufficient%20Transport%20Layer%20Protection)  

[Hazelcast Documentation: Encryption](https://docs.hazelcast.org/docs/3.5/manual/html/encryption.html)  

[CWE-326: Inadequate Encryption Strength](https://cwe.mitre.org/data/definitions/326.html)