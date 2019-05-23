# [May expose internal representation by returning reference to mutable object](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_REP)

 Returning a reference to a mutable object value stored in one of the object's fields
  exposes the internal representation of the object. 
   If instances
   are accessed by untrusted code, and unchecked changes to
   the mutable object would compromise security or other
   important properties, you will need to do something different.
  Returning a new copy of the object is better approach in many situations.