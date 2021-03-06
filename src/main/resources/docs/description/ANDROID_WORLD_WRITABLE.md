# [World writable file (Android)](https://find-sec-bugs.github.io/bugs.htm#ANDROID_WORLD_WRITABLE)

    The file written in this context is using the creation mode `MODE_WORLD_READABLE`. It might not be the
    expected behavior to expose the content being written.

    **Code at risk:**  

<pre>
fos = openFileOutput(filename, MODE_WORLD_READABLE);
fos.write(userInfo.getBytes());
</pre>

    **Solution (using MODE_PRIVATE):**  

<pre>
fos = openFileOutput(filename, MODE_PRIVATE);
</pre>

    **Solution (using local SQLite Database):**  

Using a local SQLite database is probably the best solution to store structured data. Make sure the database file is not
create on external storage. See references below for implementation guidelines.

    **References**  

    [CERT: DRD11-J. Ensure that sensitive data is kept secure](https://www.securecoding.cert.org/confluence/display/java/DRD11-J.+Ensure+that+sensitive+data+is+kept+secure)  

    [Android Official Doc: Security Tips](https://developer.android.com/training/articles/security-tips.html#InternalStorage)  

    [Android Official Doc: Context.MODE_PRIVATE](https://developer.android.com/reference/android/content/Context.html#MODE_PRIVATE)  

    [vogella.com: Android SQLite database and content provider - Tutorial](https://www.vogella.com/tutorials/AndroidSQLite/article.html#databasetutorial_database)  

    [vogella.com: Android SQLite database and content provider - Tutorial](https://www.vogella.com/tutorials/AndroidSQLite/article.html#databasetutorial_database)  

    [OWASP Mobile Top 10 2014-M2: Insecure Data Storage](https://www.owasp.org/index.php/Mobile_Top_10_2014-M2)  

    [CWE-312: Cleartext Storage of Sensitive Information](https://cwe.mitre.org/data/definitions/312.html)