# [Class doesn't serialize superclass fields](http://fb-contrib.sourceforge.net/bugdescriptions.html#PIS_POSSIBLE_INCOMPLETE_SERIALIZATION)

This method implements Serializable but is derived from a
			class that does not. The superclass has fields that are not serialized
			because this class does not take the responsibility of writing these fields out
			either using Serializable's writeObject method, or Externalizable's writeExternal
			method. Therefore when this class is read from a stream, the superclass fields
			will only be initialized to the values specified in its default constructor.
			If possible, change the superclass to implement Serializable, or implement
			Serializable or Externalizable methods in the child class.