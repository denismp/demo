/**
 * 
 */
package com.example.demo;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @author denisputnam
 *
 */
public class MyTester {
	
	private HttpClient client = HttpClientBuilder.create().build();
//	private final String USER_AGENT = "Mozilla/5.0";
//	private String cookies;
	
	private void createAuthor( String url, String name ) throws Exception {
		JSONObject json = new JSONObject();
		
		json.put("name", name);
		this.sendPost(url, json);	
	}
	
	private void createBook( String url, String title, String author ) throws Exception {
		JSONObject json = new JSONObject();
		
		json.put("title", title);
		json.put("author", author);
		this.sendPost(url, json);	
	}
	
	private void sendPost( String url, JSONObject json ) throws Exception {
		
		HttpPost request = new HttpPost(url);
		request.setHeader("Content-Type", "application/json");
//		post.setHeader("Authorization", "Basic " + this.getCredentials(true));
		
		request.setEntity(new StringEntity(json.toString()));
		
		HttpResponse response = client.execute(request);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Response code=" + responseCode);
		
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while( (line = rd.readLine()) != null ) {
			result.append(line);
		}
		
		System.out.println("RESULTS=" + result.toString());		
	}
	private void sendGet( String url, boolean auth ) throws Exception {
		
		HttpGet request = new HttpGet(url);
		request.setHeader("Content-Type", "application/json");
//		request.setHeader("Authorization", "Basic " + this.getCredentials(true));
		
		if( auth ) {
			String plainClientCredentials = "user:password";
			String base64ClientCredentials = new String( Base64.encodeBase64(plainClientCredentials.getBytes()));
			
			request.setHeader("Authorization", "Basic " + base64ClientCredentials);
		}
		
//		request.setEntity(new StringEntity(json.toString()));
		
		HttpResponse response = client.execute(request);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Response code=" + responseCode);
		
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while( (line = rd.readLine()) != null ) {
			result.append(line);
		}
		
		System.out.println("RESULTS=" + result.toString());		
	}
	private void sendPut( String url, JSONObject json ) throws Exception {
				
		HttpPut request = new HttpPut(url);
		request.setHeader("Content-Type", "application/json");
//		post.setHeader("Authorization", "Basic " + this.getCredentials(true));
		
		request.setEntity(new StringEntity(json.toString()));
		
		HttpResponse response = client.execute(request);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Response code=" + responseCode);
		
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while( (line = rd.readLine()) != null ) {
			result.append(line);
		}
		
		System.out.println("RESULTS=" + result.toString());			
	}
	private void sendDelete( String url ) throws Exception {
		
		HttpDelete request = new HttpDelete(url);
		request.setHeader("Content-Type", "application/json");
//		post.setHeader("Authorization", "Basic " + this.getCredentials(true));
		
//		request.setEntity(new StringEntity(json.toString()));
		
		HttpResponse response = client.execute(request);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Response code=" + responseCode);
		
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while( (line = rd.readLine()) != null ) {
			result.append(line);
		}
		
		System.out.println("RESULTS=" + result.toString());			
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyTester tester = new MyTester();
		
//		tester.createAuthor("http://localhost:8090/create/author", "name1");
		
		tester.createBook("http://localhost:8090/create/book", "title1", "name1");

	}

}
