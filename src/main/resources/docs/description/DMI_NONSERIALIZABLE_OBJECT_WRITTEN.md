# [Non serializable object written to ObjectOutput](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_NONSERIALIZABLE_OBJECT_WRITTEN)

This code seems to be passing a non-serializable object to the ObjectOutput.writeObject method.
If the object is, indeed, non-serializable, an error will result.