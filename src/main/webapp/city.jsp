<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<head><title>JSP</title></head>
<body>


<table>
    <%--
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
     --%>
    <tr>
        <td>监测点名称</td>
        <td>AQI空气质量指数</td>
        <td>空气质量指数类别</td>
        <td>PM2.5细微粒物</td>
        <td>PM10可吸入颗粒物</td>
        <td>CO一氧化碳</td>
        <td>NO2二氧化氮</td>
        <td>O3臭氧1小时平均</td>
        <td>O3臭氧8小时平均</td>
        <td>SO2二氧化硫</td>
    </tr>

    <c:if test="${!empty list}">

        <c:forEach items="${list}" var="p">


            <tr>
                <td><c:out value="${p.positionName}" default="-"></c:out></td>
                <td><c:out value="${p.aqi}" default="-"/></td>
                <td><c:out value="${p.quality}" default="-"></c:out></td>
                <td><c:out value="${p.pm2_5}" default="-"></c:out></td>
                <td><c:out value="${p.pm10}" default="-"></c:out></td>
                <td><c:out value="${p.co}" default="-"></c:out></td>
                <td><c:out value="${p.no2}" default="-"></c:out></td>
                <td><c:out value="${p.o3}" default="-"></c:out></td>
                <td><c:out value="${p.o3_8h}" default="-"></c:out></td>
                <td><c:out value="${p.so2}" default="-"></c:out></td>
            </tr>
        </c:forEach>

    </c:if>

</table>
${pageContext.request.contextPath}





</body>

</html>
