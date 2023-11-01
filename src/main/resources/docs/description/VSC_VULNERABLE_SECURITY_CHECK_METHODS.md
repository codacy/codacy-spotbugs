# [Non-Private and non-final security check methods are vulnerable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VSC_VULNERABLE_SECURITY_CHECK_METHODS)

        Methods that perform security checks should be prevented from being overridden, so they must be declared as
        private or final. Otherwise, these methods can be compromised when a malicious subclass overrides them
        and omits the checks.

        See SEI CERT rule [MET03-J. Methods that perform a security check must be declared private or final](https://wiki.sei.cmu.edu/confluence/display/java/MET03-J.+Methods+that+perform+a+security+check+must+be+declared+private+or+final).