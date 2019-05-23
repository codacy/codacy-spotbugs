# [serialVersionUID isn't final](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_NONFINAL_SERIALVERSIONID)

 This class defines a `serialVersionUID` field that is not final. 
  The field should be made final
   if it is intended to specify
   the version UID for purposes of serialization.