# [Test for circular dependencies among classes](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CD_CIRCULAR_DEPENDENCY)

    This class has a circular dependency with other classes. This makes building these classes
    difficult, as each is dependent on the other to build correctly. Consider using interfaces
    to break the hard dependency.