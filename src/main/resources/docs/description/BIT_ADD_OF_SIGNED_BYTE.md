# [Bitwise add of signed byte value](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BIT_ADD_OF_SIGNED_BYTE)

 Adds a byte value and a value which is known to have the 8 lower bits clear.
Values loaded from a byte array are sign extended to 32 bits
before any bitwise operations are performed on the value.
Thus, if `b[0]` contains the value `0xff`, and
`x` is initially 0, then the code
`((x << 8) + b[0])`  will sign extend `0xff`
to get `0xffffffff`, and thus give the value
`0xffffffff` as the result.

In particular, the following code for packing a byte array into an int is badly wrong: 

    int result = 0;
    for (int i = 0; i < 4; i++)
        result = ((result << 8) + b[i]);

The following idiom will work instead: 

    int result = 0;
    for (int i = 0; i < 4; i++)
        result = ((result << 8) + (b[i] & 0xff));