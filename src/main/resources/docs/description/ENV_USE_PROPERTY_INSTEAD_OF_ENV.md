# [It is preferable to use portable Java property instead of environment variable.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ENV_USE_PROPERTY_INSTEAD_OF_ENV)

        Environment variables are not portable, the variable name itself (not only the value) may be different depending on the running OS.
        Not only the names of the specific environment variables can differ (e.g. `USERNAME` in Windows and `USER` in Unix systems),
        but even the semantics differ, e.g. the case sensitivity (Windows being case-insensitive and Unix case-sensitive).
        Moreover, the Map of the environment variables returned by `java.lang.System.getenv()` and its collection views may not obey
        the general contract of the `Object.equals(java.lang.Object)` and `Object.hashCode()` methods.
        Consequently, using environment variables may have unintended side effects.
        Also, the visibility of environment variables is less restricted compared to Java Properties: they are visible to all descendants
        of the defining process, not just the immediate Java subprocess.
        For these reasons, even the Java API of `java.lang.System` advises to use Java properties (`java.lang.System.getProperty(java.lang.String)`)
        instead of environment variables (`java.lang.System.getenv(java.lang.String)`) where possible.

        If a value can be accessed through both System.getProperty() and System.getenv(), it should be accessed using the former.

        Mapping of corresponding Java System properties:

<table> 
 <tbody> 
  <tr> 
   <th>Environment variable</th> 
   <th>Property</th> 
  </tr> 
  <tr> 
   <td>JAVA_HOME</td> 
   <td>java.home</td> 
  </tr> 
  <tr> 
   <td>JAVA_VERSION</td> 
   <td>java.version</td> 
  </tr> 
  <tr> 
   <td>TEMP</td> 
   <td>java.io.tmpdir</td> 
  </tr> 
  <tr> 
   <td>TMP</td> 
   <td>java.io.tmpdir</td> 
  </tr> 
  <tr> 
   <td>PROCESSOR_ARCHITECTURE</td> 
   <td>os.arch</td> 
  </tr> 
  <tr> 
   <td>OS</td> 
   <td>os.name</td> 
  </tr> 
  <tr> 
   <td>USER</td> 
   <td>user.name</td> 
  </tr> 
  <tr> 
   <td>USERNAME</td> 
   <td>user.name</td> 
  </tr> 
  <tr> 
   <td>HOME</td> 
   <td>user.home</td> 
  </tr> 
  <tr> 
   <td>HOMEPATH</td> 
   <td>user.home</td> 
  </tr> 
  <tr> 
   <td>CD</td> 
   <td>user.dir</td> 
  </tr> 
  <tr> 
   <td>PWD</td> 
   <td>user.dir</td> 
  </tr> 
 </tbody> 
</table>

      See SEI CERT rule [ENV02-J. Do not trust the values of environment variables](https://wiki.sei.cmu.edu/confluence/display/java/ENV02-J.+Do+not+trust+the+values+of+environment+variables).