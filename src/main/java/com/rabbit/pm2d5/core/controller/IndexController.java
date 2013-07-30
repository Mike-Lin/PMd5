
package com.rabbit.pm2d5.core.controller;

import com.jfinal.core.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-29
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */

public class IndexController extends Controller {

    public void index() {


        setAttr("name","linjinzhu");

        renderJsp("/index.jsp");

    }

    public void indexhtml() {

        render("/index.html");

    }


}
