package com.rabbit.pm2d5.core.controller.analyze;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-30
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class AnalyzeDataError {

    public static final int connection_failed = 1000;

    /**
     * 处理错误
     * @param code
     * @param message
     */
    public static void error(int code, String message) {

        switch (code) {
            case connection_failed:
            {

                break;
            }

        }
    }

}
