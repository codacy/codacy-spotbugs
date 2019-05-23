# [May expose internal static state by storing a mutable object into a static field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_STATIC_REP2)

 This code stores a reference to an externally mutable object into a static
   field.
   If unchecked changes to
   the mutable object would compromise security or other
   important properties, you will need to do something different.
  Storing a copy of the object is better approach in many situations.