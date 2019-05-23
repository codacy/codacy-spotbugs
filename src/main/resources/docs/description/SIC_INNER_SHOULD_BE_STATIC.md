# [Should be a static inner class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SIC_INNER_SHOULD_BE_STATIC)

 This class is an inner class, but does not use its embedded reference
  to the object which created it.  This reference makes the instances
  of the class larger, and may keep the reference to the creator object
  alive longer than necessary.  If possible, the class should be
   made static.