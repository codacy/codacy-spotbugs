# [Class implements interface by relying on unknowing superclass methods](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCII_SPOILED_CHILD_INTERFACE_IMPLEMENTOR)

This class declares that it implements an interface, but does so by relying on methods supplied
			by superclasses, even though those superclasses know nothing about the interface in question. If you wish
			to have the child not implement all the methods of the interface, it would probably be better to declare
			the superclass as implementing the interface, and if that class does not provide all the methods, then declare
			that superclass abstract.