# [Class names shouldn't shadow simple name of superclass](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_SAME_SIMPLE_NAME_AS_SUPERCLASS)

 This class has a simple name that is identical to that of its superclass, except
that its superclass is in a different package (e.g., `alpha.Foo` extends `beta.Foo`).
This can be exceptionally confusing, create lots of situations in which you have to look at import statements
to resolve references and creates many
opportunities to accidentally define methods that do not override methods in their superclasses.