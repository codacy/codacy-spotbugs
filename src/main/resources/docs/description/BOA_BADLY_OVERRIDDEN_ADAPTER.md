# [Class overrides a method implemented in super class Adapter wrongly](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BOA_BADLY_OVERRIDDEN_ADAPTER)

 This method overrides a method found in a parent class, where that class is an Adapter that implements
a listener defined in the java.awt.event or javax.swing.event package. As a result, this method will not
get called when the event occurs.