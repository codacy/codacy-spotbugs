# [Dead store of null to local variable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_LOCAL_STORE_OF_NULL)

The code stores null into a local variable, and the stored value is not
read. This store may have been introduced to assist the garbage collector, but
as of Java SE 6.0, this is no longer needed or useful.