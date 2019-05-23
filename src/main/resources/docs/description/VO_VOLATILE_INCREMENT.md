# [An increment to a volatile field isn't atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VO_VOLATILE_INCREMENT)

This code increments a volatile field. Increments of volatile fields aren't
atomic. If more than one thread is incrementing the field at the same time,
increments could be lost.