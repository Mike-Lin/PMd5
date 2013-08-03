package com.rabbit.pm2d5.core.controller.analyze;


import com.rabbit.pm2d5.core.domain.City;
import com.rabbit.pm2d5.core.domain.PM;
import com.rabbit.pm2d5.core.domain.PM2d5;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            PM2d5.dao.add(jsonArray);
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

    public List<City> citys() {

        List<City> list = new ArrayList<City>();

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/station_names.json?token=5j1znBVAsnSf5xQyNQyq");

        try {

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jo = (JSONObject) jsonArray.get(i);

                City c = new City();
                c.setName(jo.getString("name"));

                list.add(c);

            }

            return list;

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

        return null;
    }

    public List<PM> listByCity(String city) {

        List<PM> list = new ArrayList<PM>();

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/aqi_details.json?token=5j1znBVAsnSf5xQyNQyq&city="+city);

        try {

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jo = (JSONObject) jsonArray.get(i);

                PM pm = new PM();
                pm.setAqi(jo.getString("aqi"));
                pm.setPositionName(jo.getString("position_name"));
                pm.setStationCode(jo.getString("station_code"));
                pm.setSo2(jo.getString("so2"));
                pm.setSo2_24h(jo.getString("so2_24h"));
                pm.setNo2(jo.getString("no2"));
                pm.setNo2_24h(jo.getString("no2_24h"));
                pm.setPm10(jo.getString("pm10"));
                pm.setPm10_24h(jo.getString("pm10_24h"));
                pm.setCo(jo.getString("co"));
                pm.setCo_24h(jo.getString("co_24h"));
                pm.setO3(jo.getString("o3"));
                pm.setO3_24h(jo.getString("o3_24h"));
                pm.setO3_8h(jo.getString("o3_8h"));
                pm.setO3_8h_24h(jo.getString("o3_8h_24h"));
                pm.setPm2_5(jo.getString("pm2_5"));
                pm.setPm2_5_24h(jo.getString("pm2_5_24h"));
                pm.setPrimaryPollutant(jo.getString("primary_pollutant"));
                pm.setQuality(jo.getString("quality"));
                pm.setTimePoint(jo.getString("time_point"));

                list.add(pm);

            }

            return list;

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

        return null;
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
