# [equals method fails for subtypes](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_GETCLASS_AND_CLASS_CONSTANT)

 This class has an equals method that will be broken if it is inherited by subclasses.
It compares a class literal with the class of the argument (e.g., in class `Foo`
it might check if `Foo.class == o.getClass()`).
It is better to check if `this.getClass() == o.getClass()`.