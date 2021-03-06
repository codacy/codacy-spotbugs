# [Method ignores return value](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_RETURN_VALUE_IGNORED)

 The return value of this method should be checked. One common
cause of this warning is to invoke a method on an immutable object,
thinking that it updates the object. For example, in the following code
fragment,

    String dateString = getHeaderField(name);
    dateString.trim();

the programmer seems to be thinking that the trim() method will update
the String referenced by dateString. But since Strings are immutable, the trim()
function returns a new String value, which is being ignored here. The code
should be corrected to: 

    String dateString = getHeaderField(name);
    dateString = dateString.trim();