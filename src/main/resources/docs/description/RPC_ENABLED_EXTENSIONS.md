# [Enabling extensions in Apache XML RPC server or client.](https://find-sec-bugs.github.io/bugs.htm#RPC_ENABLED_EXTENSIONS)

Enabling extensions in Apache XML RPC server or client can lead to deserialization vulnerability which would allow an
attacker to execute arbitrary code.

It's recommended not to use `setEnabledForExtensions` method of `org.apache.xmlrpc.client.XmlRpcClientConfigImpl` or `org.apache.xmlrpc.XmlRpcConfigImpl`.
By default, extensions are disabled both on the client and the server.

**References**  

[0ang3el's Blog: Beware of WS-XMLRPC library in your Java App](https://0ang3el.blogspot.com/2016/07/beware-of-ws-xmlrpc-library-in-your.html)  

[CVE-2016-5003 vulnerability reference](https://nvd.nist.gov/vuln/detail/CVE-2016-5003)