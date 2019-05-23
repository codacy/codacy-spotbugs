# [Equals method compares this object against other types in a non symmetric way](http://fb-contrib.sourceforge.net/bugdescriptions.html#NSE_NON_SYMMETRIC_EQUALS)

This class implements an equals method that compares this object against another type of object.
			This is almost always a bad thing to do, but if it is to be done, you must make sure that the basic
			symmetry rule of equivalence is maintained, that being if a equals b, then b equals a. It does not
			appear that the class that is being compared to this class knows about this class, and doesn't compare itself
			to this.

			Here's an example of a BAD equals method, do NOT do this:

    class Person {
        public boolean equals(Object o) {
            if (o instanceof Person) {
                return name.equals(((Person) o).name);
            } else if (o instanceof String) {
                return name.equals(o);
            }
            return false;
        }
    }