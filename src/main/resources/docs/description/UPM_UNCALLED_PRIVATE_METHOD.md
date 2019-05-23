# [Private method is never called](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UPM_UNCALLED_PRIVATE_METHOD)

 This private method is never called. Although it is
possible that the method will be invoked through reflection,
it is more likely that the method is never used, and should be
removed.