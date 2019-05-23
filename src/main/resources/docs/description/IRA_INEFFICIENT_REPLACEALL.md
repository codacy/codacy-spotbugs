# [Method uses replaceAll(String regex, String replacement) without any special regex characters](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IRA_INEFFICIENT_REPLACEALL)

 This method uses replaceAll(String regex, String replacement) without any special regex characters. 
It is more efficient to use
`myString.replace(CharSequence target, CharSequence replacement)`
if there is no need to use regular expressions.