# [Ignoring XML comments in SAML may lead to authentication bypass](https://find-sec-bugs.github.io/bugs.htm#SAML_IGNORE_COMMENTS)

Security Assertion Markup Language (SAML) is a single sign-on protocol that that used XML.
The SAMLResponse message include statements that describe the authenticated user.
If a user manage to place XML comments (`<!-- -->`), it may caused issue in the way the parser extract literal value.

    For example, let's take the following XML section:

<pre>
 <saml:subject>
  <saml:nameid>
   admin@domain.com
   <!---->.evil.com
  </saml:nameid>
 </saml:subject></pre>

    The user identity is `"admin@domain.com<!---->.evil.com"` but it is in fact a text node `"admin@domain.com"`, a comment `""` and a text node `".evil.com"`.
    When extracting the NameID, the service provider implementation might take first text node or the last one.

**Vulnerable Code:**  

<pre>
@Bean
ParserPool parserPool1() {
    BasicParserPool pool = new BasicParserPool();
    pool.setIgnoreComments(false);
    return pool;
}
</pre>

**Solution:**  

<pre>
@Bean
ParserPool parserPool1() {
    BasicParserPool pool = new BasicParserPool();
    pool.setIgnoreComments(true);
    return pool;
}
</pre>

**References**  

[Duo Finds SAML Vulnerabilities Affecting Multiple Implementations](https://duo.com/blog/duo-finds-saml-vulnerabilities-affecting-multiple-implementations)  

[Spring Security SAML and this week's SAML Vulnerability](https://spring.io/blog/2018/03/01/spring-security-saml-and-this-week-s-saml-vulnerability)