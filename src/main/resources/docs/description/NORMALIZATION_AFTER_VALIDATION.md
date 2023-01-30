# [String is normalzied after validation and not before it](https://find-sec-bugs.github.io/bugs.htm#NORMALIZATION_AFTER_VALIDATION)

A string must not be normalized after validation because it may allow an attacker to bypass validation using a tricky
string which becomes malicious after the normalization. For example, a program may filter out the ⟨script⟩ tags from
HTML input to avoid cross-site scripting (XSS) and other vulnerabilities. However, in unicode, the same string can have
many different representations. For example, \uFE64 is normalized to ⟨ and \uFE65 is normalized to ⟩. Thus the
if an attacker passes the string "\uFE64" + "script" + "\uFE65" the validation check fails to detect the ⟨script⟩ tag,
but thereafter the string is normalized to the ⟨script⟩ tag in the input:

<pre>
Pattern pattern = Pattern.compile("[&lt;&gt;]"); // Check for angle brackets
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
  throw new IllegalStateException();
}
s = Normalizer.normalize(s, Form.NFKC);
</pre>

The proper way is to do the normalization before the validation so the passed string is first changed to ⟨script⟩
which fails to be validated:

<pre>
s = Normalizer.normalize(s, Form.NFKC);
Pattern pattern = Pattern.compile("[&lt;&gt;]");
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
  throw new IllegalStateException();
}
</pre>

**References**  

[CERT: IDS01-J. Normalize strings before validating them](https://wiki.sei.cmu.edu/confluence/display/java/IDS01-J.+Normalize+strings+before+validating+them)