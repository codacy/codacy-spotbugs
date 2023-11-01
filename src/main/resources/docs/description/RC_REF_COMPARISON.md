# [Suspicious reference comparison](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RC_REF_COMPARISON)

 This method compares two reference values using the == or != operator,
where the correct way to compare instances of this type is generally
with the equals() method.
It is possible to create distinct instances that are equal but do not compare as == since
they are different objects.
Examples of classes which should generally
not be compared by reference are java.lang.Integer, java.lang.Float, etc. RC_REF_COMPARISON covers
only wrapper types for primitives. Suspicious types list can be extended by adding frc.suspicious
system property with comma-separated classes:

    <systemPropertyVariables>
                  <frc.suspicious>java.time.LocalDate,java.util.List</frc.suspicious>
               </systemPropertyVariables>