# [Method discards result of readLine after checking if it is non-null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_DONT_JUST_NULL_CHECK_READLINE)

 The value returned by readLine is discarded after checking to see if the return
value is non-null. In almost all situations, if the result is non-null, you will want
to use that non-null value. Calling readLine again will give you a different line.