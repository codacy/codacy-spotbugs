# [Read of unwritten field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_UNWRITTEN_FIELD)

 The program is dereferencing a field that does not seem to ever have a non-null value written to it.
Unless the field is initialized via some mechanism not seen by the analysis,
dereferencing this value will generate a null pointer exception.