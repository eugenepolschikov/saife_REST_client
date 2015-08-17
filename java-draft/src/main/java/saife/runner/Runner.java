package saife.runner;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import saife.logic.HttpMethods;

/**
 * Hello world!
 */
public class Runner {
    public static void main(String[] args) {
//        .e.g of JSON request
//        String url = ApiUtils.serverURL+"/api/hr/v2/offers/"+offer_reference+".json"; // the last one with paging=0;1

//        ================= 1=================
        String url = "https://dashboard.saifeinc.com/api/v2/interactive/login";

        Header[] headers = {
//                new BasicHeader("Content-type", "application/x-www-form-urlencoded")
//                ,new BasicHeader("Content-type", "application/x-www-form-urlencoded")
//                ,new BasicHeader("Accep", "text/html,text/xml,application/xml")
//                ,new BasicHeader("Connection", "keep-alive")
//                ,new BasicHeader("keep-alive", "115")
//                ,new BasicHeader("User-Agent", "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
        };

        Header[] headersJson = {
                new BasicHeader("Content-Type", "application/json;application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Accept", "application/json")
        };

        String _resp[] = HttpMethods.doPOST(url, headersJson, null);
//        ============ end of 1   ======================

//        request via authorization header

        Header[] headersJson2 = {
                new BasicHeader("Content-Type", "application/json;application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Authorization", "Basic NlFISkgwOUVEODJLUEgwRUVXOUhTWjVESjdNR1JQRkFDQkVDRUtFMVNOOVFLRUE0RjJBMDo=")
        };
        url = "https://dashboard.saifeinc.com/api/v2/certificate.json";
        String _resp2[]  = HttpMethods.doGET(url, headersJson2);

/*        String _ret[] = oac.doGET(url, DeskCommonHelper.headersJson);
        Assert.assertTrue(_ret[0].contains("200 OK"), "Check - return code (200)");

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject)parser.parse(_ret[1]);
        JSONObject offer = (JSONObject)root.get("offer");
*/

    }
}
