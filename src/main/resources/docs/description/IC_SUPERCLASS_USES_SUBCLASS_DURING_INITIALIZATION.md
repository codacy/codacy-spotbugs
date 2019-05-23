# [Superclass uses subclass during initialization](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION)

 During the initialization of a class, the class makes an active use of a subclass.
That subclass will not yet be initialized at the time of this use.
For example, in the following code, `foo` will be null.

    public class CircularClassInitialization {
        static class InnerClassSingleton extends CircularClassInitialization {
            static InnerClassSingleton singleton = new InnerClassSingleton();
        }

        static CircularClassInitialization foo = InnerClassSingleton.singleton;
    }