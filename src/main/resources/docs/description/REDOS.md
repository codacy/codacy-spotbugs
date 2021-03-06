# [Regex DOS (ReDOS)](https://find-sec-bugs.github.io/bugs.htm#REDOS)

    Regular expressions (Regex) are frequently subject to Denial of Service (DOS) attacks (called ReDOS). This is due to the fact that regex engines
    may take a large amount of time when analyzing certain strings, depending on how the regex is defined.

    For example, for the regex: `^(a+)+$`, the input "`aaaaaaaaaaaaaaaaX`" will cause the regex engine to analyze 65536
different paths.<sup>[1] Example taken from OWASP references</sup>

Therefore, it is possible that a single request may cause a large amount of computation on the server side.
The problem with this regex, and others like it, is that there are two different ways the same input character can be accepted by the
Regex due to the `+` (or a `*`) inside the parenthesis, and the `+` (or a `*`) outside the parenthesis. The way this is written, either `+` could
consume the character 'a'. To fix this, the regex should be rewritten to eliminate the ambiguity. For example, this could simply be
rewritten as: `^a+$`, which is presumably what the author meant anyway (any number of a's). Assuming that's what the original
regex meant, this new regex can be evaluated quickly, and is not subject to ReDOS.

**References**  

[Sebastian Kubeck's Weblog: Detecting and Preventing ReDoS Vulnerabilities](https://sebastiankuebeck.wordpress.com/2011/03/01/detecting-and-preventing-redos-vulnerabilities/)  

<sup>[1]</sup> [OWASP: Regular expression Denial of Service](https://www.owasp.org/index.php/Regular_expression_Denial_of_Service_-_ReDoS)  

[CWE-400: Uncontrolled Resource Consumption ('Resource Exhaustion')](https://cwe.mitre.org/data/definitions/400.html)