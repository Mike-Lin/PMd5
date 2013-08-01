
package com.rabbit.pm2d5.core.controller;

import com.jfinal.core.Controller;
import com.rabbit.pm2d5.core.controller.analyze.AnalyzeData;
import com.rabbit.pm2d5.core.domain.PM2d5;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-29
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */

public class IndexController extends Controller {

    // 首页
    public void index() {


        setAttr("name","linjinzhu");

        // 获取数据
        AnalyzeData analyzeData = new AnalyzeData();
        List<PM2d5> list = analyzeData.getList();


        // 数据放到session
        setAttr("list", list);



        renderJsp("/index.jsp");

    }

    public void indexhtml() {

        render("/index.html");

    }


}
