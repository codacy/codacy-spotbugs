# [hasNext method invokes next](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_CALLING_NEXT_FROM_HASNEXT)

The hasNext() method invokes the next() method. This is almost certainly wrong,
since the hasNext() method is not supposed to change the state of the iterator,
and the next method is supposed to change the state of the iterator.