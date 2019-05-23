# [Serializable class defines a final transient field](http://fb-contrib.sourceforge.net/bugdescriptions.html#NFF_NON_FUNCTIONAL_FIELD)

This serializable class defines a field as both transient and final. As transient fields
			are not serialized across the stream, it is required that some piece of code reinitialize that field
			when it is deserialized. But since constructors aren't called when deserializing, the field is not initialized.
			And since the field is final, no other method can initialize it either.