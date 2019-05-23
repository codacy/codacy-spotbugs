# [Unread public/protected field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD)

 This field is never read. 
The field is public or protected, so perhaps
    it is intended to be used with classes not seen as part of the analysis. If not,
consider removing it from the class.