# [Object deserialization is used in {1}](https://find-sec-bugs.github.io/bugs.htm#OBJECT_DESERIALIZATION)

    Object deserialization of untrusted data can lead to remote code execution, if there is a class in classpath that allows
    the trigger of malicious operation.

    Libraries developers tend to fix class that provided potential malicious trigger. There are still classes that are
    known to trigger Denial of Service<sup>[1]</sup>.

    Deserialization is a sensible operation that has a great history of vulnerabilities. The web application might
    become vulnerable as soon as a new vulnerability is found in the Java Virtual Machine<sup>[2] [3]</sup>.

**Code at risk:**  

<pre>
public UserData deserializeObject(InputStream receivedFile) throws IOException, ClassNotFoundException {

    try (ObjectInputStream in = new ObjectInputStream(receivedFile)) {
        return (UserData) in.readObject();
    }
}
</pre>

**Solutions:**  

Avoid deserializing object provided by remote users.

**References**  

[CWE-502: Deserialization of Untrusted Data](https://cwe.mitre.org/data/definitions/502.html)  

[Deserialization of untrusted data](https://www.owasp.org/index.php/Deserialization_of_untrusted_data)  

[Serialization and Deserialization ](https://www.oracle.com/technetwork/java/seccodeguide-139067.html#8)  

[A tool for generating payloads that exploit unsafe Java object deserialization](https://github.com/frohoff/ysoserial)  

[1] [Example of Denial of Service using the class `java.util.HashSet`](https://gist.github.com/coekie/a27cc406fc9f3dc7a70d)  

[2] [OpenJDK: Deserialization issue in ObjectInputStream.readSerialData() (CVE-2015-2590)](https://bugzilla.redhat.com/show_bug.cgi?id=CVE-2015-2590)  

[3] [Rapid7: Sun Java Calendar Deserialization Privilege Escalation (CVE-2008-5353)](https://www.rapid7.com/db/modules/exploit/multi/browser/java_calendar_deserialize)