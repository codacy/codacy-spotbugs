# [Servlet reflected cross site scripting vulnerability in error page](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#XSS_REQUEST_PARAMETER_TO_SEND_ERROR)

This code directly writes an HTTP parameter to a Server error page (using HttpServletResponse.sendError). Echoing this untrusted input allows
for a reflected cross site scripting
vulnerability. See [http://en.wikipedia.org/wiki/Cross-site_scripting](http://en.wikipedia.org/wiki/Cross-site_scripting)
for more information.

SpotBugs looks only for the most blatant, obvious cases of cross site scripting.
If SpotBugs found _any_, you _almost certainly_ have more cross site scripting
vulnerabilities that SpotBugs doesn't report. If you are concerned about cross site scripting, you should seriously
consider using a commercial static analysis or pen-testing tool.