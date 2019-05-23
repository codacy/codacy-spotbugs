# [Method compiles the regular expression in a loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIL_PATTERN_COMPILE_IN_LOOP_INDIRECT)

 The method creates the same regular expression inside the loop, so it will be compiled every iteration.
It would be more optimal to precompile this regular expression using Pattern.compile outside of the loop.