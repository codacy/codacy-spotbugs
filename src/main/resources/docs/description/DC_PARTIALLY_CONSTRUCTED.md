# [Possible exposure of partially initialized object](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DC_PARTIALLY_CONSTRUCTED)

Looks like this method uses lazy field initialization with double-checked locking.
  While the field is correctly declared as volatile, it's possible that the internal structure of
  the object is changed after the field assignment, thus another thread may see the partially initialized object.

To fix this problem consider storing the object into the local variable first
  and save it to the volatile field only after it's fully constructed.