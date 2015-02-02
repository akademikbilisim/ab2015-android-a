
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class HTTPUtilities {

    public static String getRequest(String getURL, List<NameValuePair> httpParams)
            throws IOException {
        HttpContext localContext = new BasicHttpContext();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,
                CookiePolicy.RFC_2109);
        HttpGet getRequest;
        if (httpParams != null) {
            getRequest = new HttpGet(getURL + "?" + URLEncodedUtils
                    .format(httpParams, "utf-8"));
        } else {
            getRequest = new HttpGet(getURL);
        }
        getRequest.setHeader("Accept", "application/json");
        getRequest.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(getRequest, localContext);
        return EntityUtils.toString(response.getEntity());
    }

    public static String postRequest(String postURL, JSONObject postData)
            throws IOException {
        HttpContext localContext = new BasicHttpContext();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,
                CookiePolicy.RFC_2109);
        HttpPost postRequest = new HttpPost(postURL);
        StringEntity stringEntity = new StringEntity(postData.toString(), "UTF-8");
        postRequest.setEntity(stringEntity);
        postRequest.setHeader("Accept", "application/json");
        postRequest.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(postRequest, localContext);
        return EntityUtils.toString(response.getEntity());
    }

}
