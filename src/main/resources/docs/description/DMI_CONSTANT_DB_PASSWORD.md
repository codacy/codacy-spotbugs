# [Hardcoded constant database password](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_CONSTANT_DB_PASSWORD)

This code creates a database connect using a hardcoded, constant password. Anyone with access to either the source code or the compiled code can
    easily learn the password.