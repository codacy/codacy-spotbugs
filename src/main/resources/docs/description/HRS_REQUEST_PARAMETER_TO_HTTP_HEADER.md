# [HTTP Response splitting vulnerability](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HRS_REQUEST_PARAMETER_TO_HTTP_HEADER)

This code directly writes an HTTP parameter to an HTTP header, which allows for a HTTP response splitting
vulnerability. See [http://en.wikipedia.org/wiki/HTTP_response_splitting](http://en.wikipedia.org/wiki/HTTP_response_splitting)
for more information.

SpotBugs looks only for the most blatant, obvious cases of HTTP response splitting.
If SpotBugs found _any_, you _almost certainly_ have more
vulnerabilities that SpotBugs doesn't report. If you are concerned about HTTP response splitting, you should seriously
consider using a commercial static analysis or pen-testing tool.