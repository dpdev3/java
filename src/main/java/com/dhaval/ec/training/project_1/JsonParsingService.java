package com.dhaval.ec.training.project_1;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

public class JsonParsingService {
	
	
	public Todo  getTodoFromWebAPI() {
		
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 
		 HttpGet request = new HttpGet(url);

		 
		 try {
			CloseableHttpResponse response = httpClient.execute(request);
			
			 // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());     
            
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                
             JSONTokener jsonObject = new JSONTokener("");
             
             
             
            }
			
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 return null;

		 
		 
		
		
		
	}

}
