# [WebView with geolocation activated (Android)](https://find-sec-bugs.github.io/bugs.htm#ANDROID_GEOLOCATION)

    It is suggested to ask the user for a confirmation about obtaining its geolocation.

    **Code at risk:**  

<pre>
webView.setWebChromeClient(new WebChromeClient() {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
    }
});
</pre>

    **Suggested code:**  

    Limit the sampling of geolocation and ask the user for confirmation.

<pre>
webView.setWebChromeClient(new WebChromeClient() {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);

        //Ask the user for confirmation
    }
});
</pre>

    **References**  

    [CERT: DRD15-J. Consider privacy concerns when using Geolocation API](https://www.securecoding.cert.org/confluence/display/java/DRD15-J.+Consider+privacy+concerns+when+using+Geolocation+API)  

    [Wikipedia: W3C Geolocation API](https://en.wikipedia.org/wiki/W3C_Geolocation_API)  

    [W3C: Geolocation Specification](https://w3c.github.io/geolocation-api/)