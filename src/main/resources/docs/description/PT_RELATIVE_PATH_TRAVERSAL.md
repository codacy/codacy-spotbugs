# [Relative path traversal in servlet](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PT_RELATIVE_PATH_TRAVERSAL)

The software uses an HTTP request parameter to construct a pathname that should be within a restricted directory, but it does not properly neutralize sequences such as ".." that can resolve to a location that is outside of that directory.

See [http://cwe.mitre.org/data/definitions/23.html](http://cwe.mitre.org/data/definitions/23.html)
for more information.

SpotBugs looks only for the most blatant, obvious cases of relative path traversal.
If SpotBugs found _any_, you _almost certainly_ have more
vulnerabilities that SpotBugs doesn't report. If you are concerned about relative path traversal, you should seriously
consider using a commercial static analysis or pen-testing tool.