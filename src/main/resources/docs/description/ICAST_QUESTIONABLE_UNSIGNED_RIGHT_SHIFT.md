# [Unsigned right shift cast to short/byte](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ICAST_QUESTIONABLE_UNSIGNED_RIGHT_SHIFT)

The code performs an unsigned right shift, whose result is then
cast to a short or byte, which discards the upper bits of the result.
Since the upper bits are discarded, there may be no difference between
a signed and unsigned right shift (depending upon the size of the shift).