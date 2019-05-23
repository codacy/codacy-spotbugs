# [Method needlessly defines parameter with concrete classes](http://fb-contrib.sourceforge.net/bugdescriptions.html#OCP_OVERLY_CONCRETE_PARAMETER)

This method uses concrete classes for parameters when only methods defined in an implemented
			interface or superclass are used. Consider increasing the abstraction of the interface to
			make low impact changes easier to accomplish in the future.

Take the following example:  

    private void appendToList(ArrayList<String> list) {
        if (list.size() < 100) {
            list.add("Foo");
        }
    }

				The parameter list is currently defined as an `ArrayList`, which is a concrete implementation of the `List` interface.
				Specifying `ArrayList` is unnecessary here, because we aren't using any `ArrayList`-specific methods (like `ensureCapacity()` or `trimToSize()`).
				Instead of using the concrete definition, it is better to do something like:  

    private void appendToList(List<String> list) {
        ...

				If the design ever changes, e.g. a `LinkedList` is used instead, this code won't have to change.

IDEs tend to have tools to help generalize parameters.  For example, in Eclipse, the refactoring tool [Generalize Declared Type](http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fref-menu-refactor.htm) helps find an appropriate level of concreteness.