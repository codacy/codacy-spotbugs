# [Overly permissive file permission](https://find-sec-bugs.github.io/bugs.htm#OVERLY_PERMISSIVE_FILE_PERMISSION)

It is generally a bad practices to set overly permissive file permission such as read+write+exec for all users.
If the file affected is a configuration, a binary, a script or sensitive data, it can lead to privilege escalation or information leakage.

It is possible that another service, running on the same host as your application, gets compromised.
Services typically run under a different user. A compromised service account could be use to read your configuration, add execution instruction to scripts or alter the data file.
To limite the damage from other services or local users, you should limited to permission of your application files.

**Vulnerable Code 1 (symbolic notation):**  

<pre>
Files.setPosixFilePermissions(configPath, PosixFilePermissions.fromString("rw-rw-rw-"));
</pre>

**Solution 1 (symbolic notation):**  

<pre>
Files.setPosixFilePermissions(configPath, PosixFilePermissions.fromString("rw-rw----"));
</pre>

**Vulnerable Code 2 (Object-oriented implementation):**  

<pre>
Set
 <posixfilepermission>
   perms = new HashSet&lt;&gt;();
perms.add(PosixFilePermission.OWNER_READ);
perms.add(PosixFilePermission.OWNER_WRITE);
perms.add(PosixFilePermission.OWNER_EXECUTE);

perms.add(PosixFilePermission.GROUP_READ);
perms.add(PosixFilePermission.GROUP_WRITE);
perms.add(PosixFilePermission.GROUP_EXECUTE);

perms.add(PosixFilePermission.OTHERS_READ);
perms.add(PosixFilePermission.OTHERS_WRITE);
perms.add(PosixFilePermission.OTHERS_EXECUTE);

 </posixfilepermission></pre>

**Solution 2 (Object-oriented implementation):**  

<pre>
Set
 <posixfilepermission>
   perms = new HashSet&lt;&gt;();
perms.add(PosixFilePermission.OWNER_READ);
perms.add(PosixFilePermission.OWNER_WRITE);
perms.add(PosixFilePermission.OWNER_EXECUTE);

perms.add(PosixFilePermission.GROUP_READ);
perms.add(PosixFilePermission.GROUP_WRITE);
perms.add(PosixFilePermission.GROUP_EXECUTE);

 </posixfilepermission></pre>

**References**  

[CWE-732: Incorrect Permission Assignment for Critical Resource](https://cwe.mitre.org/data/definitions/732.html)  

[A guide to Linux Privilege Escalation](https://payatu.com/guide-linux-privilege-escalation/)  

[File system permissions](https://en.wikipedia.org/wiki/File_system_permissions)