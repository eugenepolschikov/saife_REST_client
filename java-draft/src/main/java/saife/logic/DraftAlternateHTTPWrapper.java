package saife.logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author Eugene Polschikov
 * Date 12.08.2015
 * this is draft class !!!
 */
public class DraftAlternateHTTPWrapper {


    public void testHttpRequestSender() throws IOException {
        String url_endpoint = "https://www.google.com";
        URL inputUrl = new URL(url_endpoint);
        HttpURLConnection huc = (HttpURLConnection) inputUrl.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();



//        huc.getResponseCode() == 409;
        if(huc.getResponseCode() == 200){
          System.out.println("GET to endpoint\t"+url_endpoint+"\tPASSED\n"+"response message:\t"
                  +huc.getResponseMessage());
        }


    }


}
