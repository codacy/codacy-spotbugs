# [Class defines equal(Object); should it be equals(Object)?](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_BAD_EQUAL)

 This class defines a method `equal(Object)`.  This method does
not override the `equals(Object)` method in `java.lang.Object`,
which is probably what was intended.