# [Broadcast (Android)](https://find-sec-bugs.github.io/bugs.htm#ANDROID_BROADCAST)

    Broadcast intents can be listened by any application with the appropriate permission. It is suggested to avoid transmitting
    sensitive information when possible.

    **Code at risk:**  

<pre>
Intent i = new Intent();
i.setAction("com.insecure.action.UserConnected");
i.putExtra("username", user);
i.putExtra("email", email);
i.putExtra("session", newSessionId);

this.sendBroadcast(v1);
</pre>

    **Solution (if possible):**  

<pre>
Intent i = new Intent();
i.setAction("com.secure.action.UserConnected");

sendBroadcast(v1);
</pre>

    **Configuration (receiver)<sup>[1] Source: StackOverflow</sup>:**  

<pre>

 <manifest ...>

  <!-- Permission declaration -->

  <permission android:name="my.app.PERMISSION" />

  <receiver android:name="my.app.BroadcastReceiver" android:permission="my.app.PERMISSION"> 
   <!-- Permission enforcement --> 
   <intent-filter> 
    <action android:name="com.secure.action.UserConnected" /> 
   </intent-filter> 
  </receiver>

    ...

 </manifest>
</pre>

    **Configuration (sender)<sup>[1] Source: StackOverflow</sup>:**  

<pre>

 <manifest>

  <!-- We declare we own the permission to send broadcast to the above receiver -->

  <uses-permission android:name="my.app.PERMISSION" />

  <!-- With the following configuration, both the sender and the receiver apps need to be signed by the same developer certificate. -->

  <permission android:name="my.app.PERMISSION" android:protectionLevel="signature" />

 </manifest>
</pre>

    **References**  

    [CERT: DRD03-J. Do not broadcast sensitive information using an implicit intent](https://www.securecoding.cert.org/confluence/display/java/DRD03-J.+Do+not+broadcast+sensitive+information+using+an+implicit+intent)  

    [Android Official Doc: BroadcastReceiver (Security)](https://developer.android.com/reference/android/content/BroadcastReceiver.html#Security)  

    [Android Official Doc: Receiver configuration (see `android:permission`)](https://developer.android.com/guide/topics/manifest/receiver-element.html)  

    <sup>[1]</sup> [StackOverflow: How to set permissions in broadcast sender and receiver in android](https://stackoverflow.com/a/21513368/89769)  

    [CWE-925: Improper Verification of Intent by Broadcast Receiver](https://cwe.mitre.org/data/definitions/925.html)  

    [CWE-927: Use of Implicit Intent for Sensitive Communication](https://cwe.mitre.org/data/definitions/927.html)