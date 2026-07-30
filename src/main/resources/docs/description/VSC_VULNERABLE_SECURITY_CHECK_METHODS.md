# [Non-Private and non-final security check methods are vulnerable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VSC_VULNERABLE_SECURITY_CHECK_METHODS)

        Methods that perform security checks should be prevented from being overridden, so they must be declared as
        private or final. Otherwise, these methods can be compromised when a malicious subclass overrides them
        and omits the checks.

        See SEI CERT rule [MET03-J. Methods that perform a security check must be declared private or final](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/methods-met/met03-j/).