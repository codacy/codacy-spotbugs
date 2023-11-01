# [Assertion is used to validate an argument of a public method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AA_ASSERTION_OF_ARGUMENTS)

Asssertions must not be used to validate arguments of public methods because the validations are
        not performed if assertions are disabled.

        See SEI CERT rule [MET01-J. Never use assertions to validate method arguments](https://wiki.sei.cmu.edu/confluence/display/java/MET01-J.+Never+use+assertions+to+validate+method+arguments)
        for more information.