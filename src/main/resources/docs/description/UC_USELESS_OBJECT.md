# [Useless object created](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UC_USELESS_OBJECT)

Our analysis shows that this object is useless.
It's created and modified, but its value never goes outside the method or produces any side effect.
Either there is a mistake and object was intended to be used, or it can be removed.

This analysis rarely produces false-positives. Common false-positive cases include:

- This object used to implicitly throw some obscure exception.

- This object used as a stub to generalize the code.

- This object used to hold strong references to weak/soft-referenced objects.