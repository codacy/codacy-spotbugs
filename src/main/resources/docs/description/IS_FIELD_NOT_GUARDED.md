# [Field not guarded against concurrent access](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IS_FIELD_NOT_GUARDED)

 This field is annotated with net.jcip.annotations.GuardedBy or javax.annotation.concurrent.GuardedBy,
but can be accessed in a way that seems to violate those annotations.