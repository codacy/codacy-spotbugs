# [Unsafe hash equals](http://find-sec-bugs.github.io/bugs.htm#UNSAFE_HASH_EQUALS)

An attacker might be able to detect the value of the secret hash due to the exposure of comparison timing. When the
functions `Arrays.equals()` or `String.equals()` are called, they will exit earlier if fewer
bytes are matched.

**Vulnerable Code:**  

<pre>
String actualHash = ...

if(userInput.equals(actualHash)) {
    ...
}</pre>

**Solution:**  

<pre>
String actualHash = ...

if(MessageDigest.isEqual(userInput.getBytes(),actualHash.getBytes())) {
    ...
}</pre>

**References**  

[CWE-203: Information Exposure Through DiscrepancyKey](https://cwe.mitre.org/data/definitions/203.html)