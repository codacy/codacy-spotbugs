# [Useless suppression on a class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#US_USELESS_SUPPRESSION_ON_CLASS)

      Suppressing annotations `&SuppressFBWarnings` should be removed from the source code as soon as they are no more needed.
      Leaving them may result in accidental warnings suppression.
      The unnecessary annotation is not reported when the class is annotated with an `&Generated` annotation with retention CLASS or RUNTIME.