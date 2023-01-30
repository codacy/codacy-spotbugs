# [Dangerous combination of permissions granted](https://find-sec-bugs.github.io/bugs.htm#DANGEROUS_PERMISSION_COMBINATION)

Certain combinations of permissions can produce significant capability increases and should not be granted. Granting
ReflectPermission on the target suppressAccessChecks is dangerous in that information (possibly confidential) and
methods normally unavailable would be accessible to malicious code. Similarly, the permission
`java.lang.RuntimePermission` applied to target createClassLoader grants code the permission to create a
`ClassLoader` object.
This is extremely dangerous, because malicious applications that can instantiate their own class loaders could
then load their own rogue classes into the system. These newly loaded classes could be placed into any protection
domain by the class loader, thereby automatically granting the classes the permissions for that domain.

**Dangerous permission combinations:**  

<pre>
PermissionCollection pc = super.getPermissions(cs);
pc.add(new ReflectPermission("suppressAccessChecks"));
</pre>

<pre>
PermissionCollection pc = super.getPermissions(cs);
pc.add(new RuntimePermission("createClassLoader"));
</pre>

References  

[CERT: ENV03-J. Do not grant dangerous combinations of permissions](https://wiki.sei.cmu.edu/confluence/display/java/ENV03-J.+Do+not+grant+dangerous+combinations+of+permissions)