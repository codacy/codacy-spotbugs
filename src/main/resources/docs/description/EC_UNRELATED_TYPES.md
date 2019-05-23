# [Call to equals() comparing different types](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_UNRELATED_TYPES)

 This method calls equals(Object) on two references of different
class types and analysis suggests they will be to objects of different classes
at runtime. Further, examination of the equals methods that would be invoked suggest that either
this call will always return false, or else the equals method is not be symmetric (which is
a property required by the contract
for equals in class Object).