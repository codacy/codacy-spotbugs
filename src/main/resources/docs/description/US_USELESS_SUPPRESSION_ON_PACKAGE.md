# [Useless suppression on a package](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#US_USELESS_SUPPRESSION_ON_PACKAGE)

      Suppressing annotation `&SuppressFBWarnings` should be removed from the source code as soon as they are no more needed.
      Leaving them may result in accidental warnings suppression.
      The annotation was probably added to suppress a warning raised by SpotBugs, but now SpotBugs does not report the bug anymore. Either
      the bug was solved or SpotBugs was updated, and the bug is no longer raised by that code.
      The unnecessary annotation is not reported when the package's `package-info` is annotated with an `&Generated` annotation with retention CLASS or RUNTIME.