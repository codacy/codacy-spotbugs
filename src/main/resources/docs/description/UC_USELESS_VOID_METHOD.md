# [Useless non-empty void method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UC_USELESS_VOID_METHOD)

Our analysis shows that this non-empty void method does not actually perform any useful work.
Please check it: probably there's a mistake in its code or its body can be fully removed.

We are trying to reduce the false positives as much as possible, but in some cases this warning might be wrong.
Common false-positive cases include:

*   The method is intended to trigger loading of some class which may have a side effect.
*   The method is intended to implicitly throw some obscure exception.