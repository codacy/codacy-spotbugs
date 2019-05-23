# [Code contains a hard coded reference to an absolute pathname](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_HARDCODED_ABSOLUTE_FILENAME)

This code constructs a File object using a hard coded to an absolute pathname
(e.g., `new File("/home/dannyc/workspace/j2ee/src/share/com/sun/enterprise/deployment");`