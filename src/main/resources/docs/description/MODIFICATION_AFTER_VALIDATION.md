# [String is modified after validation and not before it](https://find-sec-bugs.github.io/bugs.htm#MODIFICATION_AFTER_VALIDATION)

A string must not be modified after validation because it may allow an attacker to bypass validation using a tricky
string which becomes malicious after the modification. For example, a program may filter out the ⟨script⟩ tags from
HTML input to avoid cross-site scripting (XSS) and other vulnerabilities. If non-character code points  are deleted
from the input following validation, an attacker may pass the string "⟨scr"+"\uFDEF"+"ipt⟩" so that the validation
check fails to detect the ⟨script⟩ tag, but the subsequent removal of the non-character code pont creates a ⟨script⟩
tag in the input:

<pre>
Pattern pattern = Pattern.compile("<script>");
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
  throw new IllegalArgumentException("Invalid input");
}

s = s.replaceAll("[\\p{Cn}]", "");
</script></pre>

The proper way is to perform the modification before the validation so the passed string is first changed to ⟨script⟩
which fails to be validated:

<pre>
s = s.replaceAll("[\\p{Cn}]", "\uFFFD");
Pattern pattern = Pattern.compile("<script>");
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
  throw new IllegalArgumentException("Invalid input");
}
</script></pre>

**References**  

[CERT: IDS11-J. Perform any string modifications before validation](https://wiki.sei.cmu.edu/confluence/display/java/IDS11-J.+Perform+any+string+modifications+before+validation)