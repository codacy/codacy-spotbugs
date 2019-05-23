# [Double.longBitsToDouble invoked on an int](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_LONG_BITS_TO_DOUBLE_INVOKED_ON_INT)

 The Double.longBitsToDouble method is invoked, but a 32 bit int value is passed
    as an argument. This almost certainly is not intended and is unlikely
    to give the intended result.