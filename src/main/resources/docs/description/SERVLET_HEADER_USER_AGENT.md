# [Untrusted User-Agent header](https://find-sec-bugs.github.io/bugs.htm#SERVLET_HEADER_USER_AGENT)

The header "User-Agent" can easily be spoofed by the client. Adopting different behaviors based on the User-Agent (for
crawler UA) is not recommended.

**Reference**  

[CWE-807: Untrusted Inputs in a Security Decision](https://cwe.mitre.org/data/definitions/807.html)