# [Could be refactored into a named static inner class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SIC_INNER_SHOULD_BE_STATIC_ANON)

 This class is an inner class, but does not use its embedded reference
  to the object which created it.  This reference makes the instances
  of the class larger, and may keep the reference to the creator object
  alive longer than necessary.  If possible, the class should be
  made into a _static_ inner class. Since anonymous inner
classes cannot be marked as static, doing this will require refactoring
the inner class so that it is a named inner class.