# [Method intentionally throws RuntimeException.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#THROWS_METHOD_THROWS_RUNTIMEEXCEPTION)

        Method intentionally throws RuntimeException.  

        According to the [SEI CERT ERR07-J rule](https://wiki.sei.cmu.edu/confluence/display/java/ERR07-J.+Do+not+throw+RuntimeException%2C+Exception%2C+or+Throwable), 
        throwing a RuntimeException may cause errors, like the caller not being able to examine the exception and therefore cannot properly recover from it.  

        Moreover, throwing a RuntimeException would force the caller to catch RuntimeException and therefore violate the 
        [SEI CERT ERR08-J rule](https://wiki.sei.cmu.edu/confluence/display/java/ERR08-J.+Do+not+catch+NullPointerException+or+any+of+its+ancestors).  

        Please note that you can derive from Exception or RuntimeException and may throw a new instance of that exception.