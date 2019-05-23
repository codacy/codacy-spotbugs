# [Method must be private in order for serialization to work](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_METHOD_MUST_BE_PRIVATE)

 This class implements the `Serializable` interface, and defines a method
  for custom serialization/deserialization. But since that method isn't declared private,
  it will be silently ignored by the serialization/deserialization API.