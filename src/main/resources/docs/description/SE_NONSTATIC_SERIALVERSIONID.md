# [serialVersionUID isn't static](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_NONSTATIC_SERIALVERSIONID)

 This class defines a `serialVersionUID` field that is not static. 
  The field should be made static
   if it is intended to specify
   the version UID for purposes of serialization.