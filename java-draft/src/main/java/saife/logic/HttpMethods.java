package saife.logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.Args;

public class HttpMethods {
	
	public static String[] doGET(String url, Header[] headers){

			System.out.println("http(s) GET >>> "+url);
		String[] _ret = null;
		try{
			_ret = new String[2];
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			request.setHeaders(headers);
			HttpResponse response = httpclient.execute(request);
			_ret[0] = response.getStatusLine().toString();// Response status
			InputStream data = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
			String responeLine;
			StringBuilder responseBuilder = new StringBuilder();
			while ((responeLine = bufferedReader.readLine()) != null) {
				responseBuilder.append(responeLine);
			}
			_ret[1] = responseBuilder.toString(); // Response content
		}catch(Exception ex){
			ex.printStackTrace();
		}
		

			System.out.println("http(s) GET <<< "+_ret[0]+" ... "+_ret[1]);
		return _ret;
	}
	
	public static String[] doPOST(String url, Header[] headers, HttpEntity entity){
		System.out.println("http(s) POST >>> "+url);
		String[] _ret = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try{
			_ret = new String[2];
			HttpPost request = new HttpPost(url);
			request.setHeaders(headers);
			request.setEntity(entity);
			HttpResponse response = httpclient.execute(request);
			_ret[0] = response.getStatusLine().toString();// Response status
			InputStream data = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
			String responeLine;
			StringBuilder responseBuilder = new StringBuilder();
			while ((responeLine = bufferedReader.readLine()) != null) {
				responseBuilder.append(responeLine);
			}
			_ret[1] = responseBuilder.toString(); // Response content
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		System.out.println("http(s) <<< "+_ret[0]+" ... "+_ret[1]);
		return _ret;
	}

	public static String[] doPUT(String url, Header[] headers, HttpEntity entity){
		String[] _ret = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try{
			_ret = new String[2];
			HttpPut request = new HttpPut(url);
			request.setHeaders(headers);
			request.setEntity(entity);	
			HttpResponse response = httpclient.execute(request);
			_ret[0] = response.getStatusLine().toString();// Response status
			InputStream data = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
			String responeLine;
			StringBuilder responseBuilder = new StringBuilder();
			while ((responeLine = bufferedReader.readLine()) != null) {
				responseBuilder.append(responeLine);
			}
			_ret[1] = responseBuilder.toString(); // Response content
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		System.out.println("http(s) <<< "+_ret[0]+" ... "+_ret[1]);
		return _ret;
	}

	public static String[] doDELETE(String url, Header[] headers){
		String[] _ret = null;
		try{
			_ret = new String[2];
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpDelete request = new HttpDelete(url);
			request.setHeaders(headers);
			HttpResponse response = httpclient.execute(request);
			_ret[0] = response.getStatusLine().toString();// Response status
			InputStream data = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
			String responeLine;
			StringBuilder responseBuilder = new StringBuilder();
			while ((responeLine = bufferedReader.readLine()) != null) {
				responseBuilder.append(responeLine);
			}
			_ret[1] = responseBuilder.toString(); // Response content
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("http(s) <<< "+_ret[0]+" ... "+_ret[1]);
		return _ret;
	}


    private static String responseBuilder(){
        String result="";


        return result;
    }
	
	
}
