# [Unreleased HttpRequest network resources (local)](http://fb-contrib.sourceforge.net/bugdescriptions.html#HCP_HTTP_REQUEST_RESOURCES_NOT_FREED_LOCAL)

FindBugs has detected an `org.apache.http.HttpRequest` (e.g. `HttpGet`, `HttpPost`, etc)
            that didn't release its associated resources.  Code like the following:   

    public String requestInfo(URI u) {
        HttpGet httpGet = new HttpGet(u);
        try(CloseableHttpResponse response = client.execute(httpGet);) {
            return getResponseAsString(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

				will freeze after a few requests, usually with no indication as to why. 

				The reason this code freezes is because `org.apache.http.HttpRequest`s need to explicitly release their connection
				with a call to either `reset()` or `releaseConnection()`, **even if the request is a local**.
				The garbage collector will not release these resources, leading to the frustrating freezing scenario described above.

The above example can be easily fixed:  

    public String requestInfo(URI u) {
        HttpGet httpGet = new HttpGet(u);
        try(CloseableHttpResponse response = client.execute(httpGet);) {
            return getResponseAsString(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally { httpGet.reset(); }
        return null;
    }