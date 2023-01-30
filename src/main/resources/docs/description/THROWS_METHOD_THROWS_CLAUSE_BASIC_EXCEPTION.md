# [Method lists Exception in its throws clause.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#THROWS_METHOD_THROWS_CLAUSE_BASIC_EXCEPTION)

        Method lists Exception in its throws clause.  

        When declaring a method, the types of exceptions in the throws clause should be the most specific.
        Therefore, using Exception in the throws clause would force the caller to either use it in its own throws clause, or use it in a try-catch block (when it does not necessarily 
        contain any meaningful information about the thrown exception).  

        For more information, see the [SEI CERT ERR07-J rule](https://wiki.sei.cmu.edu/confluence/display/java/ERR07-J.+Do+not+throw+RuntimeException%2C+Exception%2C+or+Throwable).