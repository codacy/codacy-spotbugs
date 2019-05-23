# [Computation of average could overflow](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IM_AVERAGE_COMPUTATION_COULD_OVERFLOW)

The code computes the average of two integers using either division or signed right shift,
and then uses the result as the index of an array.
If the values being averaged are very large, this can overflow (resulting in the computation
of a negative average).  Assuming that the result is intended to be nonnegative, you
can use an unsigned right shift instead. In other words, rather that using `(low+high)/2`,
use `(low+high) >>> 1`

This bug exists in many earlier implementations of binary search and merge sort.
Martin Buchholz [found and fixed it](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6412541)
in the JDK libraries, and Joshua Bloch
[widely
publicized the bug pattern](http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html).