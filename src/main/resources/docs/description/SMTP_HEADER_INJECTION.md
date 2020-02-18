# [SMTP Header Injection](https://find-sec-bugs.github.io/bugs.htm#SMTP_HEADER_INJECTION)

Simple Mail Transfer Protocol (SMTP) is a the text based protocol used for email delivery.
Like with HTTP, headers are separate by new line separator.
If user input is place in a header line, the application should remove
or replace new line characters (`CR` / `LF`).
You should use a safe wrapper such as [Apache Common Email](https://commons.apache.org/proper/commons-email/userguide.html)
and [Simple Java Mail](http://www.simplejavamail.org) which filter special characters that can lead to header injection.

    **Vulnerable Code:**  

<pre>
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("noreply@your-organisation.com"));
message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress("target@gmail.com")});
message.setSubject(usernameDisplay + " has sent you notification"); //Injectable API
message.setText("Visit your ACME Corp profile for more info.");
Transport.send(message);
</pre>

    **Solution**  

Use [Apache Common Email](https://commons.apache.org/proper/commons-email/userguide.html) or [Simple Java Mail](http://www.simplejavamail.org).

**References**  

[OWASP SMTP Injection](https://www.owasp.org/index.php/Testing_for_IMAP/SMTP_Injection_(OTG-INPVAL-011))  

[CWE-93: Improper Neutralization of CRLF Sequences ('CRLF Injection')](https://cwe.mitre.org/data/definitions/93.html)  

[Commons Email: User Guide](https://commons.apache.org/proper/commons-email/userguide.html)  

[Simple Java Mail Website](http://www.simplejavamail.org)  

[StackExchange InfoSec: What threats come from CRLF in email generation?](https://security.stackexchange.com/a/54100/24973)