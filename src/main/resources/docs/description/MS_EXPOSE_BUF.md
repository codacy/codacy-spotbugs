# [May expose internal representation by returning a buffer sharing non-public data](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_EXPOSE_BUF)

 A public static method either returns a buffer (java.nio.*Buffer) which wraps an array that is part of the
  static state of the class by holding a reference only to this same array or it returns a shallow-copy of a buffer
  that is part of the static stat of the class which shares its reference with the original buffer.
   Any code that calls this method can freely modify the underlying array.
   One fix is to return a read-only buffer or a new buffer with a copy of the array.