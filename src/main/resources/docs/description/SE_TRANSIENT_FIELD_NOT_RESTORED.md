# [Transient field that isn't set by deserialization.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_TRANSIENT_FIELD_NOT_RESTORED)

 This class contains a field that is updated at multiple places in the class, thus it seems to be part of the state of the class. However, since the field is marked as transient and not set in readObject or readResolve, it will contain the default value in any
deserialized instance of the class.