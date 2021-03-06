# [Dynamic JSP inclusion](https://find-sec-bugs.github.io/bugs.htm#JSP_INCLUDE)

The inclusion of JSP file allow the entry of dynamic value. It may allow an attacker to control the JSP page included.
If this is the case, an attacker will try to include a file on disk that he controls. By including arbitrary files, the
attacker gets the ability to execute any code.

    **Vulnerable Code:**

<pre>
 <jsp:include page="${param.secret_param}" /></pre>

    **Solution:**

<pre>
 <c:if test="${param.secret_param == 'page1'}">

  <jsp:include page="page1.jsp" />

 </c:if></pre>

**References**  

[InfosecInstitute: File Inclusion Attacks](https://resources.infosecinstitute.com/file-inclusion-attacks/)  

[WASC-05: Remote File Inclusion](http://projects.webappsec.org/w/page/13246955/Remote%20File%20Inclusion)