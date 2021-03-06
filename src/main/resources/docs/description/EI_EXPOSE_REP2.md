# [May expose internal representation by incorporating reference to mutable object](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_REP2)

 This code stores a reference to an externally mutable object into the
  internal representation of the object. 
   If instances
   are accessed by untrusted code, and unchecked changes to
   the mutable object would compromise security or other
   important properties, you will need to do something different.
  Storing a copy of the object is better approach in many situations.