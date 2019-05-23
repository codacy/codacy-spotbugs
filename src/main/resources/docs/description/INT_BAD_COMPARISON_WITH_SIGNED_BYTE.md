# [Bad comparison of signed byte](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#INT_BAD_COMPARISON_WITH_SIGNED_BYTE)

 Signed bytes can only have a value in the range -128 to 127\. Comparing
a signed byte with a value outside that range is vacuous and likely to be incorrect.
To convert a signed byte `b` to an unsigned value in the range 0..255,
use `0xff & b`.