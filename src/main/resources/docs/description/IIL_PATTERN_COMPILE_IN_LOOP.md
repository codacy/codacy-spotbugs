# [Method calls Pattern.compile in a loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIL_PATTERN_COMPILE_IN_LOOP)

 The method calls Pattern.compile inside the loop passing the constant arguments.
If the Pattern should be used several times there's no reason to compile it for each loop iteration.
Move this call outside of the loop or even into static final field.