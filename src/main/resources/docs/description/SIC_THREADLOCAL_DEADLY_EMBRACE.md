# [Deadly embrace of non-static inner class and thread local](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SIC_THREADLOCAL_DEADLY_EMBRACE)

 This class is an inner class, but should probably be a static inner class.
  As it is, there is a serious danger of a deadly embrace between the inner class
  and the thread local in the outer class. Because the inner class isn't static,
  it retains a reference to the outer class.
  If the thread local contains a reference to an instance of the inner
  class, the inner and outer instance will both be reachable
  and not eligible for garbage collection.