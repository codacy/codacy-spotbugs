# [Transient field of class that isn't Serializable.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_TRANSIENT_FIELD_OF_NONSERIALIZABLE_CLASS)

 The field is marked as transient, but the class isn't Serializable, so marking it as transient
has absolutely no effect.
This may be leftover marking from a previous version of the code in which the class was Serializable, or
it may indicate a misunderstanding of how serialization works.

_This bug is reported only if special option <tt>reportTransientFieldOfNonSerializableClass</tt> is set._