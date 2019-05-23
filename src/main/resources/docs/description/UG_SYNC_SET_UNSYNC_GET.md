# [Unsynchronized get method, synchronized set method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UG_SYNC_SET_UNSYNC_GET)

 This class contains similarly-named get and set
  methods where the set method is synchronized and the get method is not. 
  This may result in incorrect behavior at runtime, as callers of the get
  method will not necessarily see a consistent state for the object. 
  The get method should be made synchronized.