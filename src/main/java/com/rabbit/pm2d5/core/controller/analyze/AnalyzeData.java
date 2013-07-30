package com.rabbit.pm2d5.core.controller.analyze;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-30
 * Time: 下午8:25
 * To change this template use File | Settings | File Templates.
 */


public class AnalyzeData {

    private final String BASE_URL = "http://www.pm25.in/api/";
    // 1.10、获取所有城市的监测点列表（每小时10次）
    private final String station_names_url = "querys/station_names.json";
    // 1.11、获取实施了新《环境空气质量标准》的城市列表，即有PM2.5数据的城市列表（每小时10次）
    private final String detail_url = "api/querys.json";
    // 1.12、获取所有城市的空气质量详细数据（每小时5次）
    private final String all_cities_url = "querys/all_cities.json";
    // 1.13、获取全部城市的空气质量指数(AQI)排行榜（每小时15次）
    private final String aqi_ranking_url = "querys/aqi_ranking.json";
    private final String appkey_release = "YJJM8siP67fmnMJyGmNP";
    private final String appkey_dev = "5j1znBVAsnSf5xQyNQyq";


    public void saveData() {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/pm2_5.json?city=珠海&token=5j1znBVAsnSf5xQyNQyq");

        try {

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String area = (String) jsonObject.get("area");

            }


        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

    }


    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/pm2_5.json?city=珠海&token=5j1znBVAsnSf5xQyNQyq");

        try {

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");

            JSONArray jsonArray = new JSONArray(responseBody);
            System.out.println(jsonArray);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String area = (String) jsonObject.get("area");
                System.out.println(area + "\t" + jsonObject.getString("position_name"));

            }


        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

    }

}
