/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador.pushy;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class PushyAPI
{
    public static ObjectMapper mapper = new ObjectMapper();
    public static final String PUSHY_SECRET_API_KEY = "e4bada13fc2fa762016e54dc0d437c8ce60fdeebc72d9234cfd375ddb2007d09";

    public static void sendPush( PushyPushRequest req ) throws Exception
    {
        // Get custom HTTP client
        HttpClient client = new DefaultHttpClient();

        // Create post request
        HttpPost request = new HttpPost( "https://api.pushy.me/push?api_key=" + PUSHY_SECRET_API_KEY );

        // Set content type to JSON
        request.addHeader("Content-Type", "application/json");

        // Convert API request to JSON
        String json = mapper.writeValueAsString(req);
        

        /*Prueba pr  = (Prueba) req.data;
        Gson gson = new Gson(); 
        String json = gson.toJson(pr);*/
        // Send post data as string
        request.setEntity(new StringEntity(json));

        // Execute the request
        HttpResponse response = client.execute(request, new BasicHttpContext());

        // Get response JSON as string
        String responseJSON = EntityUtils.toString(response.getEntity());

        // Convert JSON response into HashMap
        Map<String, Object> map = mapper.readValue(responseJSON, Map.class);

        // Got an error?
        if ( map.containsKey("error") )
        {
            // Throw it
            throw new Exception(map.get("error").toString());
        }
    }
}