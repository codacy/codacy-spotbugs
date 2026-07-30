# [Accessibility of the overridden or hidden method was increased.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IAOM_DO_NOT_INCREASE_METHOD_ACCESSIBILITY)

        Increasing the accessibility of overridden or hidden methods permits a malicious subclass to offer wider
        access to the restricted method than was originally intended. Consequently, programs must override methods
        only when necessary and must declare methods final whenever possible to prevent malicious subclassing. When
        methods cannot be declared final, programs must refrain from increasing the accessibility of overridden methods.

        See SEI CERT rule [MET04-J. Do not increase the accessibility of overridden or hidden methods](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/methods-met/met04-j/).