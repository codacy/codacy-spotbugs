# [Use the nextInt method of Random rather than nextDouble to generate a random integer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_NEXTINT_VIA_NEXTDOUBLE)

If `r` is a `java.util.Random`, you can generate a random number from `0` to `n-1`
using `r.nextInt(n)`, rather than using `(int)(r.nextDouble() * n)`.

The argument to nextInt must be positive. If, for example, you want to generate a random
value from -99 to 0, use `-r.nextInt(100)`.