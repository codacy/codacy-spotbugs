# [Method lists Throwable in its throws clause, but it could be more specific.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#THROWS_METHOD_THROWS_CLAUSE_THROWABLE)

        Method lists Throwable in its throws clause.  

        When declaring a method, the types of exceptions in the throws clause should be the most specific.
        Therefore, using Throwable in the throws clause would force the caller to either use it in its own throws clause, or use it in a try-catch block (when it does not necessarily
        contain any meaningful information about the thrown exception).  

        Furthermore, using Throwable like that is semantically a bad practice, considered that Throwables include Errors as well, but by definition they occur in unrecoverable scenarios.  

        For more information, see the [SEI CERT ERR07-J rule](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/exceptional-behavior-err/err07-j/).

        See [CWE-397: Declaration of Throws for Generic Exception](https://cwe.mitre.org/data/definitions/397.html).