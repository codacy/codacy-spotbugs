# [HTTP Parameter Pollution](https://find-sec-bugs.github.io/bugs.htm#HTTP_PARAMETER_POLLUTION)

Concatenating unvalidated user input into a URL can allow an attacker to override the value of a request parameter. Attacker may be able to override existing parameter values, inject a new parameter or exploit variables out of a direct reach. HTTP Parameter Pollution (HPP) attacks consist of injecting encoded query string delimiters into other existing parameters. If a web application does not properly sanitize the user input, a malicious user may compromise the logic of the application to perform either client-side or server-side attacks.  

In the following example the programmer has not considered the possibility that an attacker could provide a parameter `lang` such as `en&user_id=1`, which would enable him to change the `user_id` at will.

    **Vulnerable Code:**  

<pre>String input = request.getParameter("lang");
GetMethod get = new GetMethod("http://www.host.com/viewDetails");
get.setQueryString("lang=" + input + "&amp;user_id=" + userId);
get.execute();</pre>

    **Solution:**  

You can either encode user input before placing it in HTTP parameters or use the
[UriBuilder class](https://hc.apache.org/httpcomponents-client-4.3.x/httpclient/apidocs/org/apache/http/client/utils/URIBuilder.html)
from [Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/).

<pre>
URIBuilder uriBuilder = new URIBuilder("http://www.host.com/viewDetails");
uriBuilder.addParameter("lang", input);
uriBuilder.addParameter("user_id", userId);

HttpGet httpget = new HttpGet(uriBuilder.build().toString()); //OK
</pre>

**References**  

[CAPEC-460: HTTP Parameter Pollution (HPP)](https://capec.mitre.org/data/definitions/460.html)