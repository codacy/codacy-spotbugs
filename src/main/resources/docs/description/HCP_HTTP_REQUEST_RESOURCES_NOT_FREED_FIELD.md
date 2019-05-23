# [Unreleased HttpRequest network resources (field)](http://fb-contrib.sourceforge.net/bugdescriptions.html#HCP_HTTP_REQUEST_RESOURCES_NOT_FREED_FIELD)

FindBugs has detected an `org.apache.http.HttpRequest` (e.g. `HttpGet`, `HttpPost`, etc)
            that didn't release its associated resources.  Code like the following:   

<pre>code&gt;
private HttpGet httpGet;

public String requestInfo(URI u) {
    this.httpGet = new HttpGet(u);
    try(CloseableHttpResponse response = client.execute(httpGet);) {
        return getResponseAsString(response);
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
</pre>

				will freeze after a few requests, usually with no indication as to why.  

				The reason this code freezes is because `org.apache.http.HttpRequest`s need to explicitly release their connection
				with a call to either `reset()` or `releaseConnection()`.  The above example can be easily fixed:  

    private HttpGet httpGet;
    ...
    public String requestInfo(URI u) {
        this.httpGet = new HttpGet(u);
        try(CloseableHttpResponse response = client.execute(httpGet);) {
            return getResponseAsString(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally { this.httpGet.reset(); }
        return null;
    }