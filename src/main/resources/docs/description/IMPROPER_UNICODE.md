# [Improper handling of Unicode transformations](https://find-sec-bugs.github.io/bugs.htm#IMPROPER_UNICODE)

Unexpected behavior in unicode transformations can sometimes lead to bugs, some of them affecting software security.
A code that applies the uppercase transformation to two strings could mistakenly interpret both strings as being equal.

In the code bellow, the string `"ADM\u0131N"` would cause the condition to be true.
When the uppercase transformation is applied, the character `\u0131` will becomme '\u0049' (I).
It can be an issue if the developer only one user to be `"ADMIN"`.  

<pre>
if(username.toUpperCase().equals("ADMIN")) {
  //...
}
</pre>

Similar characters transformations can occurs with normalization functions.
In the code bellow, the string `"BAC\u212AUP"` would cause the condition to be true.
When the normalization transformation is applied, the character `\u212A` will becomme '\u0048' (K).  

<pre>
if(Normalizer.normalize(input, Normalizer.Form.NFC).equals("BACKUP")) {
  //...
}
</pre>

**References**  

[Unicode for Security Professionals](https://www.gosecure.net/blog/2020/08/04/unicode-for-security-professionals/)  

[Unicode Security Guide: Character Transformations](http://websec.github.io/unicode-security-guide/character-transformations/)  

[CWE-176: Improper Handling of Unicode Encoding](https://cwe.mitre.org/data/definitions/176.html)  

[Unicode: Unicode Security Considerations](http://unicode.org/reports/tr36/)