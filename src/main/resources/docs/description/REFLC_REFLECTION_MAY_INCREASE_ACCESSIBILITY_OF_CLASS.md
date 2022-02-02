# [Public method uses reflection to create a class it gets in its parameter which could increase the accessibility of any class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#REFLC_REFLECTION_MAY_INCREASE_ACCESSIBILITY_OF_CLASS)

        [SEI CERT SEC05-J](https://wiki.sei.cmu.edu/confluence/display/java/SEC05-J.+Do+not+use+reflection+to+increase+accessibility+of+classes%2C+methods%2C+or+fields) rule forbids the use of reflection to increase accessibility of classes, methods or fields. If
        a class in a package provides a public method which takes an instance of java.lang.Class as its parameter and
        calls its newInstance() method then it increases accessibility of classes in the same package without public
        constructors. An attacker code may call this method and pass such class to create an instance of it. This should
        be avoided by either making the method non-public or by checking for package access permission on the package.
        A third possibility is to use the java.beans.Beans.instantiate() method instead of java.lang.Class.newInstance()
        which checks whether the Class object being received has any public constructors.