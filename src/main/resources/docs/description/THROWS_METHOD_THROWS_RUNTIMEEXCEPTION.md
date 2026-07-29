# [Method intentionally throws RuntimeException.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#THROWS_METHOD_THROWS_RUNTIMEEXCEPTION)

        Method intentionally throws RuntimeException.  

        According to the [SEI CERT ERR07-J rule](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/exceptional-behavior-err/err07-j/),
        throwing a RuntimeException may cause errors, like the caller not being able to examine the exception and therefore cannot properly recover from it.  

        Moreover, throwing a RuntimeException would force the caller to catch RuntimeException and therefore violate the
        [SEI CERT ERR08-J rule](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/exceptional-behavior-err/err08-j/).  

        Please note that you can derive from Exception or RuntimeException and may throw a new instance of that exception.

        See [CWE-397: Declaration of Throws for Generic Exception](https://cwe.mitre.org/data/definitions/397.html).