# [Iterator next() method cannot throw NoSuchElementException](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IT_NO_SUCH_ELEMENT)

 This class implements the `java.util.Iterator` interface. 
  However, its `next()` method is not capable of throwing
  `java.util.NoSuchElementException`.  The `next()`
  method should be changed so it throws `NoSuchElementException`
  if is called when there are no more elements to return.