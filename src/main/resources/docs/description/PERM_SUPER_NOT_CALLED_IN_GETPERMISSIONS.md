# [Custom class loader does not call its superclass's getPermissions()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PERM_SUPER_NOT_CALLED_IN_GETPERMISSIONS)

       [SEI CERT rule SEC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/platform-security-sec/sec07-j/) requires that custom class loaders must always call their superclass's getPermissions()
       method in their own getPermissions() method to initialize the object they return at the end. Omitting it means
       that a class defined using this custom class loader has permissions that are completely independent of those
       specified in the systemwide policy file. In effect, the class's permissions override them.