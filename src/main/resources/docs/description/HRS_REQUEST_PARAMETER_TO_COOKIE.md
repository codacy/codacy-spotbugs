# [HTTP cookie formed from untrusted input](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HRS_REQUEST_PARAMETER_TO_COOKIE)

This code constructs an HTTP Cookie using an untrusted HTTP parameter. If this cookie is added to an HTTP response, it will allow a HTTP response splitting
vulnerability. See [http://en.wikipedia.org/wiki/HTTP_response_splitting](http://en.wikipedia.org/wiki/HTTP_response_splitting)
for more information.

SpotBugs looks only for the most blatant, obvious cases of HTTP response splitting.
If SpotBugs found _any_, you _almost certainly_ have more
vulnerabilities that SpotBugs doesn't report. If you are concerned about HTTP response splitting, you should seriously
consider using a commercial static analysis or pen-testing tool.