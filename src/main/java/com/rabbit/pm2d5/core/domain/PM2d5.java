package com.rabbit.pm2d5.core.domain;

import com.jfinal.plugin.activerecord.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-31
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class PM2d5 extends Model<PM2d5> {

    public static final PM2d5 dao = new PM2d5();
    public static String[] fields = {"id", "aqi", "area","pm2_5",};

    /**
     {
     aqi: 98,
     area: "武汉",
     co: 0.67,
     co_24h: 0.69,
     no2: 32,
     no2_24h: 31,
     o3: 118,
     o3_24h: 204,
     o3_8h: 156,
     o3_8h_24h: 162,
     pm10: 102,
     pm10_24h: 90,
     pm2_5: 37,
     pm2_5_24h: 37,
     position_name: null,
     primary_pollutant: null,
     quality: "良",
     so2: 13,
     so2_24h: 26,
     station_code: null,
     time_point: "2013-08-01T20:00:00Z"
     }
     */
    private Integer id;
    private String aqi;             // 空气质量指数
    private String positionName;    // 监测点名称
    private String stationCode;     // 监测点编码
    private String so2;             // 二氧化硫1小时平均
    private String so2_24h;         // 二氧化硫24小时滑动平均
    private String no2;             // 二氧化氮1小时平均
    private String no2_24h;         // 二氧化氮24小时滑动平均
    private String pm10;            // 颗粒物（粒径<=10um）1小时平均
    private String pm10_24h;        // 颗粒物（粒径<=10um）24小时滑动平均
    private String co;              // 一氧化碳1小时平均
    private String co_24h;          // 一氧化碳24小时滑动平均
    private String o3;              // 臭氧1小时平均
    private String o3_24h;          // 臭氧24小时滑动平均
    private String o3_8h;           // 臭氧8小时平均
    private String o3_8h_24h;       // 臭氧8小时滑动平均的24小时均值
    private String pm2_5;           // 颗粒物（粒径小于等于2.5μm）1小时平均
    private String pm2_5_24h;       // 颗粒物（粒径小于等于2.5μm）24小时滑动平均
    private String primaryPollutant; // 首要污染物
    private String quality;         // 空气质量指数类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
    private String timePoint;       // 数据发布的时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getSo2_24h() {
        return so2_24h;
    }

    public void setSo2_24h(String so2_24h) {
        this.so2_24h = so2_24h;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getNo2_24h() {
        return no2_24h;
    }

    public void setNo2_24h(String no2_24h) {
        this.no2_24h = no2_24h;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm10_24h() {
        return pm10_24h;
    }

    public void setPm10_24h(String pm10_24h) {
        this.pm10_24h = pm10_24h;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCo_24h() {
        return co_24h;
    }

    public void setCo_24h(String co_24h) {
        this.co_24h = co_24h;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getO3_24h() {
        return o3_24h;
    }

    public void setO3_24h(String o3_24h) {
        this.o3_24h = o3_24h;
    }

    public String getO3_8h() {
        return o3_8h;
    }

    public void setO3_8h(String o3_8h) {
        this.o3_8h = o3_8h;
    }

    public String getO3_8h_24h() {
        return o3_8h_24h;
    }

    public void setO3_8h_24h(String o3_8h_24h) {
        this.o3_8h_24h = o3_8h_24h;
    }

    public String getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(String pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public String getPm2_5_24h() {
        return pm2_5_24h;
    }

    public void setPm2_5_24h(String pm2_5_24h) {
        this.pm2_5_24h = pm2_5_24h;
    }

    public String getPrimaryPollutant() {
        return primaryPollutant;
    }

    public void setPrimaryPollutant(String primaryPollutant) {
        this.primaryPollutant = primaryPollutant;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }




    public PM2d5 getPM2d5() {

        return PM2d5.dao.findById(get("id"));
    }

    public void add(JSONArray jsonArray) throws JSONException {

        Map<String,Object> map = new HashMap<String, Object>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject j = jsonArray.optJSONObject(i);
            Iterator it = j.keys();

            while (it.hasNext()) {
                String n = (String) it.next();
                PM2d5.dao.set(n, j.get(n)).save();
                map.put(n, j.get(n));
            }
        }

        System.out.println(map.size());
        PM2d5.dao.setAttrs(map).save();

    }

}
