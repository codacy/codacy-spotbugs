# [Could be refactored into a static inner class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SIC_INNER_SHOULD_BE_STATIC_NEEDS_THIS)

 This class is an inner class, but does not use its embedded reference
  to the object which created it except during construction of the
inner object.  This reference makes the instances
  of the class larger, and may keep the reference to the creator object
  alive longer than necessary.  If possible, the class should be
  made into a _static_ inner class. Since the reference to the
   outer object is required during construction of the inner instance,
   the inner class will need to be refactored so as to
   pass a reference to the outer instance to the constructor
   for the inner class.