# [Method allocates an object, only to get the class object](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_NEW_FOR_GETCLASS)

This method allocates an object just to call getClass() on it, in order to
  retrieve the Class object for it. It is simpler to just access the .class property of the class.