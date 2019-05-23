# [Incorrect lazy initialization of static field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#LI_LAZY_INIT_STATIC)

 This method contains an unsynchronized lazy initialization of a non-volatile static field.
Because the compiler or processor may reorder instructions,
threads are not guaranteed to see a completely initialized object,
_if the method can be called by multiple threads_.
You can make the field volatile to correct the problem.
For more information, see the
[Java Memory Model web site](http://www.cs.umd.edu/~pugh/java/memoryModel/).