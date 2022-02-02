# [May expose internal static state by creating a buffer which stores an external array into a static field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_STATIC_BUF2)

 This code creates a buffer which stores a reference to an external array or the array of an external buffer into
  a static field.
   If unchecked changes to
   the array would compromise security or other
   important properties, you will need to do something different.
  Storing a copy of the array is a better approach in many situations.