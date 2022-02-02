# [An increment to a volatile field isn't atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VO_VOLATILE_INCREMENT)

This code increments/decrements a volatile field. Increments/Decrements of volatile fields aren't
atomic. If more than one thread is incrementing/decrementing the field at the same time,
increments/decrements could be lost.