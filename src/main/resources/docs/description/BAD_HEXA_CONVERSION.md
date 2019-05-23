# [Bad hexadecimal concatenation](http://find-sec-bugs.github.io/bugs.htm#BAD_HEXA_CONVERSION)

When converting a byte array containing a hash signature to a human readable string, a conversion mistake can be made if 
the array is read byte by byte. The following sample illustrates the use of the method `Integer.toHexString()` which will trim any leading zeroes
from each byte of the computed hash value.

<pre>
MessageDigest md = MessageDigest.getInstance("SHA-256");
byte[] resultBytes = md.digest(password.getBytes("UTF-8"));

StringBuilder stringBuilder = new StringBuilder();
for(byte b :resultBytes) {
    stringBuilder.append( Integer.toHexString( b &amp; 0xFF ) );
}

return stringBuilder.toString();</pre>

This mistake weakens the hash value computed since it introduces more collisions. 
For example, the hash values "0x0679" and "0x6709" would both output as "679" for the above function.

In this situation, the method `Integer.toHexString()` should be replaced with `String.format()` as follows:

<pre>stringBuilder.append( String.format( "%02X", b ) );</pre>

**References**  

[CWE-704: Incorrect Type Conversion or Cast](http://cwe.mitre.org/data/definitions/704.html)