# [serialVersionUID isn't long](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_NONLONG_SERIALVERSIONID)

 This class defines a `serialVersionUID` field that is not long. 
  The field should be made long
   if it is intended to specify
   the version UID for purposes of serialization.