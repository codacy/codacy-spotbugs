# [Cannot use reflection to check for presence of annotation without runtime retention](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_ANNOTATION_IS_NOT_VISIBLE_TO_REFLECTION)

 Unless an annotation has itself been annotated with  @Retention(RetentionPolicy.RUNTIME), the annotation cannot be observed using reflection
(e.g., by using the isAnnotationPresent method).
   .