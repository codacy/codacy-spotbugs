# [Class is Serializable but its superclass doesn't define a void constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_NO_SUITABLE_CONSTRUCTOR)

 This class implements the `Serializable` interface
   and its superclass does not. When such an object is deserialized,
   the fields of the superclass need to be initialized by
   invoking the void constructor of the superclass.
   Since the superclass does not have one,
   serialization and deserialization will fail at runtime.