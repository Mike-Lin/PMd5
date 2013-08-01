package com.rabbit.pm2d5.core.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.rabbit.pm2d5.core.controller.IndexController;
import com.rabbit.pm2d5.core.controller.analyze.AnalyzeDataController;
import com.rabbit.pm2d5.core.domain.PM2d5;

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
        me.add("/", IndexController.class);
        me.add("/analyze", AnalyzeDataController.class);
    }

    public void configPlugin(Plugins me) {

        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost:3306/pm2d5", "root", "root");
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);

        // 配置数据库方言
        arp.setDialect(new MysqlDialect());
        arp.addMapping("pm2d5", "id", PM2d5.class);

    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }

}
