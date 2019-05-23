# [Possible double check of field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DC_DOUBLECHECK)

 This method may contain an instance of double-checked locking. 
  This idiom is not correct according to the semantics of the Java memory
  model.  For more information, see the web page
  [http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html).