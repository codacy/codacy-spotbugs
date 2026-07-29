# [Invocation of substring(0), which returns the same as toString()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_MISLEADING_SUBSTRING)

This code invokes substring(0) on a StringBuffer or a StringBuilder, which returns the same as toString().