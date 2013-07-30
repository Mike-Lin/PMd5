package com.rabbit.pm2d5.core.config;

import com.jfinal.config.*;
import com.jfinal.render.ViewType;
import com.rabbit.pm2d5.core.controller.IndexController;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-29
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class PMConfig extends JFinalConfig{

    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setViewType(ViewType.JSP);
    }

    public void configRoute(Routes me) {
        me.add("/index", IndexController.class);
    }

    public void configPlugin(Plugins me) {
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }
}
