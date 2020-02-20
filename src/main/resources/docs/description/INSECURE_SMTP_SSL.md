# [Insecure SMTP SSL connection](https://find-sec-bugs.github.io/bugs.htm#INSECURE_SMTP_SSL)

Server identity verification is disabled when making SSL connections. Some email libraries that enable SSL connections do not verify the server certificate by default. This is equivalent to trusting all certificates.
When trying to connect to the server, this application would readily accept a certificate issued to "victim.com".
The application would now potentially leak sensitive user information on a broken SSL connection to the victim server.

    **Vulnerable Code:**  

<pre>...
Email email = new SimpleEmail();
email.setHostName("smtp.servermail.com");
email.setSmtpPort(465);
email.setAuthenticator(new DefaultAuthenticator(username, password));
email.setSSLOnConnect(true);
email.setFrom("user@gmail.com");
email.setSubject("TestMail");
email.setMsg("This is a test mail ... :-)");
email.addTo("foo@bar.com");
email.send();
...</pre>

    **Solution:**  

Please add the following check to verify the server certificate:

<pre>email.setSSLCheckServerIdentity(true);</pre>

**References**  

[CWE-297: Improper Validation of Certificate with Host Mismatch](https://cwe.mitre.org/data/definitions/297.html)