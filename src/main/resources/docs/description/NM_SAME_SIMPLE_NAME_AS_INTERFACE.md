# [Class names shouldn't shadow simple name of implemented interface](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_SAME_SIMPLE_NAME_AS_INTERFACE)

 This class/interface has a simple name that is identical to that of an implemented/extended interface, except
that the interface is in a different package (e.g., `alpha.Foo` extends `beta.Foo`).
This can be exceptionally confusing, create lots of situations in which you have to look at import statements
to resolve references and creates many
opportunities to accidentally define methods that do not override methods in their superclasses.