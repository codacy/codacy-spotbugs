# [equals method compares class names rather than class objects](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_COMPARING_CLASS_NAMES)

 This class defines an equals method that checks to see if two objects are the same class by checking to see if the names
of their classes are equal. You can have different classes with the same name if they are loaded by
different class loaders. Just check to see if the class objects are the same.