# [May expose internal representation by returning a buffer sharing non-public data](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EI_EXPOSE_BUF)

 Returning a reference to a buffer (java.nio.*Buffer) which wraps an array stored in one of the object's fields
  exposes the internal representation of the array elements because the buffer only stores a reference to the array
  instead of copying its content. Similarly, returning a shallow-copy of such a buffer (using its duplicate() method)
  stored in one of the object's fields also exposes the internal representation of the buffer. 
   If instances are accessed by untrusted code, and unchecked changes to
   the array would compromise security or other
   important properties, you will need to do something different.
  Returning a read-only buffer (using its asReadOnly() method) or copying the array to a new buffer (using its put()
  method) is a better approach in many situations.