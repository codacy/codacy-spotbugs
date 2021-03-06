# [equals method always returns false](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_ALWAYS_FALSE)

 This class defines an equals method that always returns false. This means that an object is not equal to itself, and it is impossible to create useful Maps or Sets of this class. More fundamentally, it means
that equals is not reflexive, one of the requirements of the equals method.

The likely intended semantics are object identity: that an object is equal to itself. This is the behavior inherited from class `Object`. If you need to override an equals inherited from a different
superclass, you can use:

    public boolean equals(Object o) {
        return this == o;
    }