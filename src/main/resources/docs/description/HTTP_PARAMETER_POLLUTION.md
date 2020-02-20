# [HTTP Parameter Pollution](https://find-sec-bugs.github.io/bugs.htm#HTTP_PARAMETER_POLLUTION)

Concatenating unvalidated user input into a URL can allow an attacker to override the value of a request parameter. Attacker may be able to override existing parameter values, inject a new parameter or exploit variables out of a direct reach. HTTP Parameter Pollution (HPP) attacks consist of injecting encoded query string delimiters into other existing parameters. If a web application does not properly sanitize the user input, a malicious user may compromise the logic of the application to perform either client-side or server-side attacks.  

In the following example the programmer has not considered the possibility that an attacker could provide a parameter `lang` such as `en&user_id=1`, which would enable him to change the `user_id` at will.

    **Vulnerable Code:**  

<pre>String lang = request.getParameter("lang");
GetMethod get = new GetMethod("http://www.host.com");
get.setQueryString("lang=" + lang + "&amp;user_id=" + user_id);
get.execute();</pre>

    **Solution:**  

Sanitize user input before using it in HTTP parameters.

**References**  

[CAPEC-460: HTTP Parameter Pollution (HPP)](https://capec.mitre.org/data/definitions/460.html)