package com.novatec.serversimulation;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CallUrl {

    public CallUrl() {
    }

    public static String callPostUrl(String url) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request();
        Response response = builder.post(null);
        return response.readEntity(String.class);
}
    
    public static String callDeleteUrl(String url) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request();
        Response response = builder.delete();
        return response.readEntity(String.class);
}
    
    
    public static void callAddMappingRestWeatherCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            String data =  "{\"id\":\"aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa\",\"persistent\":true,\"priority\":0,"
                    +  "\"request\":{\"method\":\"GET\",\"urlPattern\":\"/globalweather.asmx/GetCitiesByCountry\\\\?CountryName=(\\\\S*)\"},"
                    +  "\"response\":{\"base64Body\":\"\",\"body\":\"Hello World!\",\"bodyFileName\":\"\","
                    +  "\"delayDistribution\":null,\"headers\":{},"
                    +  "\"jsonBody\":{},\"status\":0,\"transformerParameters\":{},\"transformers\":[]}}";
            
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    
    public static void callDeleteRestWeatherCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings/aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    
    public static void callAddMappingSOAPWeatherCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            String data =  "{\"id\":\"aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaac\",\"persistent\":true,\"priority\":0,"
                    +  "\"request\":{\"method\":\"POST\",\"url\":\"/globalweather.asmx\",\"bodyPatterns\":"
                    + "[\"matchesXPath\":\"<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><GetCitiesByCountry xmlns=\"http://www.webserviceX.NET\"><CountryName>Germany</CountryName></GetCitiesByCountry></soapenv:Body></soapenv:Envelope>\"],},"
                    +  "\"response\":{\"base64Body\":\"\",\"body\":\"Hello World, Soap Weather!\",\"bodyFileName\":\"\","
                    +  "\"delayDistribution\":null,\"headers\":{},"
                    +  "\"jsonBody\":{},\"status\":0,\"transformerParameters\":{},\"transformers\":[]}}";
            System.out.println(data);
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    
    public static void callDeleteSOAPWeatherCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings/aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaac");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    
    public static void callAddMappingRestCurrencyCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            conn.setRequestMethod("POST");
            String data =  "{\"id\":\"aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaab\",\"persistent\":true,\"priority\":0,"
                    +  "\"request\":{\"method\":\"GET\",\"urlPattern\":\"/country.asmx/GetCurrencyByCountry\\\\?CountryName=(\\\\S*)\"},"
                    +  "\"response\":{\"base64Body\":\"\",\"body\":\"Hello World!\",\"bodyFileName\":\"\","
                    +  "\"delayDistribution\":null,\"headers\":{},"
                    +  "\"jsonBody\":{},\"status\":0,\"transformerParameters\":{},\"transformers\":[]}}";
            
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    
    public static void callDeleteRestCurrencyCurl() {
        try {
            URL obj = new URL("http://localhost:9898/__admin/mappings/aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaab");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.close();
            new InputStreamReader(conn.getInputStream());
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    

}
