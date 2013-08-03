
package com.rabbit.pm2d5.core.controller;

import com.jfinal.core.Controller;
import com.rabbit.pm2d5.core.controller.analyze.AnalyzeData;
import com.rabbit.pm2d5.core.domain.PM;

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

        // 获取数据
        AnalyzeData analyzeData = new AnalyzeData();
        List<PM> list = analyzeData.listByCity("shanghai");


        // 当前城市的总体情况
        PM pm = list.get(list.size() - 1);
        setAttr("pm", pm);

        // 数据放到session
        list.remove(list.size() -1);
        setAttr("list", list);

        renderJsp("/index.jsp");

    }

    public void city() {



        render("/city.jsp");

    }

    public void testHtml() {
        render("test.html");
    }


}
