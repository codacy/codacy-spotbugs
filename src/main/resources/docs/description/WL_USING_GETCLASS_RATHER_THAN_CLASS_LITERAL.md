# [Synchronization on getClass rather than class literal](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#WL_USING_GETCLASS_RATHER_THAN_CLASS_LITERAL)

     This instance method synchronizes on `this.getClass()`. If this class is subclassed,
     subclasses will synchronize on the class object for the subclass, which isn't likely what was intended.
     For example, consider this code from java.awt.Label:

    private static final String base = "label";
    private static int nameCounter = 0;

    String constructComponentName() {
        synchronized (getClass()) {
            return base + nameCounter++;
        }
    }

Subclasses of `Label` won't synchronize on the same subclass, giving rise to a datarace.
     Instead, this code should be synchronizing on `Label.class`.

    private static final String base = "label";
    private static int nameCounter = 0;

    String constructComponentName() {
        synchronized (Label.class) {
            return base + nameCounter++;
        }
    }

Bug pattern contributed by Jason Mehrens.