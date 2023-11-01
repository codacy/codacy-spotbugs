# [Prevent overwriting of externalizable objects](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_PREVENT_EXT_OBJ_OVERWRITE)

The `readExternal()` method must be declared as public and is not protected from malicious callers, so the code permits any caller to reset the value of the object at any time.

To prevent overwriting of externalizable objects, you can use a Boolean flag that is set after the instance fields have been populated. You can also protect against race conditions by synchronizing on a private lock object.