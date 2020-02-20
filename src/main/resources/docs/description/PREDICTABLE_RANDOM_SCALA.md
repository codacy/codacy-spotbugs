# [Predictable pseudorandom number generator (Scala)](https://find-sec-bugs.github.io/bugs.htm#PREDICTABLE_RANDOM_SCALA)

The use of a predictable random value can lead to vulnerabilities when used in certain security critical contexts. For example, when the value is used as:

*   a CSRF token: a predictable token can lead to a CSRF attack as an attacker will know the value of the token
*   a password reset token (sent by email): a predictable password token can lead to an account takeover, since an attacker will guess the URL of the "change password" form
*   any other secret value

A quick fix could be to replace the use of `java.util.Random` with something stronger, such as **java.security.SecureRandom**.

**Vulnerable Code:**  

<pre>import scala.util.Random

def generateSecretToken() {
    val result = Seq.fill(16)(Random.nextInt)
    return result.map("%02x" format _).mkString
}</pre>

    **Solution:**

<pre>import java.security.SecureRandom

def generateSecretToken() {
    val rand = new SecureRandom()
    val value = Array.ofDim[Byte](16)
    rand.nextBytes(value)
    return value.map("%02x" format _).mkString
}</pre>

[###ERROR: 
<!--<p>
<b>Solution:</b>
<pre>import java.security.SecureRandom
import scala.util.Random._

def generateSecretToken() {
    val secRandom = javaRandomToRandom(new SecureRandom())
    val result = Seq.fill(16)(secRandom.nextInt)
    return result.map("%02x" format _).mkString
}</pre>
</p>--> ###]

**References**  

[Cracking Random Number Generators - Part 1 (http://jazzy.id.au)](https://jazzy.id.au/2010/09/20/cracking_random_number_generators_part_1.html)  

[CERT: MSC02-J. Generate strong random numbers](https://www.securecoding.cert.org/confluence/display/java/MSC02-J.+Generate+strong+random+numbers)  

[CWE-330: Use of Insufficiently Random Values](https://cwe.mitre.org/data/definitions/330.html)  

[Predicting Struts CSRF Token (Example of real-life vulnerability and exploitation)](https://blog.h3xstream.com/2014/12/predicting-struts-csrf-token-cve-2014.html)