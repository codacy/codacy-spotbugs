# ["." or "|" used for regular expression](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RE_POSSIBLE_UNINTENDED_PATTERN)

A String function is being invoked and "." or "|" is being passed
to a parameter that takes a regular expression as an argument. Is this what you intended?
For example

*   s.replaceAll(".", "/") will return a String in which _every_ character has been replaced by a '/' character
*   s.split(".") _always_ returns a zero length array of String
*   "ab|cd".replaceAll("|", "/") will return "/a/b/|/c/d/"
*   "ab|cd".split("|") will return array with six (!) elements: [, a, b, |, c, d]