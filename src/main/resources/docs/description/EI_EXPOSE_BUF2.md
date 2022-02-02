# [May expose internal representation by creating a buffer which incorporates reference to array](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_BUF2)

 This code creates a buffer which stores a reference to an external array or the array of an external buffer into
  the internal representation of the object. 
   If instances
   are accessed by untrusted code, and unchecked changes to
   the array would compromise security or other
   important properties, you will need to do something different.
  Storing a copy of the array is a better approach in many situations.