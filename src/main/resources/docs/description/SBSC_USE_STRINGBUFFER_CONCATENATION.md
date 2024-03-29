# [Method concatenates strings using + in a loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SBSC_USE_STRINGBUFFER_CONCATENATION)

 The method seems to be building a String using concatenation in a loop.
In each iteration, the String is converted to a StringBuffer/StringBuilder,
   appended to, and converted back to a String.
   This can lead to a cost quadratic in the number of iterations,
   as the growing string is recopied in each iteration. 

Better performance can be obtained by using
a StringBuffer (or StringBuilder in Java 5) explicitly.

 For example:

    // This is bad
    String s = "";
    for (int i = 0; i < field.length; ++i) {
        s = s + field[i];
    }

    // This is better
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < field.length; ++i) {
        buf.append(field[i]);
    }
    String s = buf.toString();