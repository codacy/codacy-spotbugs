# [Public static method may expose internal representation by returning a mutable object or array](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_EXPOSE_REP)

 A public static method returns a reference to a mutable object or
   an array that is part of the static state of the class.
   Any code that calls this method can freely modify
   the underlying array.
   One fix is to return a copy of the array.