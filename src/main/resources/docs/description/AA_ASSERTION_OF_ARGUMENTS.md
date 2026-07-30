# [Assertion is used to validate an argument of a public method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AA_ASSERTION_OF_ARGUMENTS)

Assertions must not be used to validate arguments of public methods because the validations are
        not performed if assertions are disabled.

        See SEI CERT rule [MET01-J. Never use assertions to validate method arguments](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/methods-met/met01-j/)
        and [CWE-617: Reachable Assertion](https://cwe.mitre.org/data/definitions/617.html)
        for more information.