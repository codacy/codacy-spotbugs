# [Non-transient non-serializable instance field in serializable class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_BAD_FIELD)

 This Serializable class defines a non-primitive instance field which is neither transient,
Serializable, or `java.lang.Object`, and does not appear to implement
the `Externalizable` interface or the
`readObject()` and `writeObject()` methods. 
Objects of this class will not be deserialized correctly if a non-Serializable
object is stored in this field.