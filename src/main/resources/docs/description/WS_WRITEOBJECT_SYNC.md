# [Class's writeObject() method is synchronized but nothing else is](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#WS_WRITEOBJECT_SYNC)

 This class has a `writeObject()` method which is synchronized;
  however, no other method of the class is synchronized.