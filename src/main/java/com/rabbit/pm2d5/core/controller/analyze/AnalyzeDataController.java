package com.rabbit.pm2d5.core.controller.analyze;

import com.jfinal.core.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-30
 * Time: 下午7:37
 * To change this template use File | Settings | File Templates.
 */
public class AnalyzeDataController extends Controller{


    public void index() {

        AnalyzeData ad = new AnalyzeData();
        ad.saveData();

        setAttr("name","linjinzhu");

        renderJsp("/index.jsp");

    }



}
