# [Class is Externalizable but doesn't define a void constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_NO_SUITABLE_CONSTRUCTOR_FOR_EXTERNALIZATION)

 This class implements the `Externalizable` interface, but does
  not define a public void constructor. When Externalizable objects are deserialized,
   they first need to be constructed by invoking the public void
   constructor. Since this class does not have one,
   serialization and deserialization will fail at runtime.