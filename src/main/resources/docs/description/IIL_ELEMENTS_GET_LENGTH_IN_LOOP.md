# [NodeList.getLength() called in a loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIL_ELEMENTS_GET_LENGTH_IN_LOOP)

 The method calls NodeList.getLength() inside the loop and NodeList was produced by getElementsByTagName call.
This NodeList doesn't store its length, but computes it every time in not very optimal way.
Consider storing the length to the variable before the loop.