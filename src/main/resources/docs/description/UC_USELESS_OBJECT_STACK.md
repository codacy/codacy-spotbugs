# [Useless object created on stack](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UC_USELESS_OBJECT_STACK)

This object is created just to perform some modifications which don't have any side-effect.
Probably something else was meant or the object can be removed.