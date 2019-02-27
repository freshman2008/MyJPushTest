package com.spacego.myjpushtest;

import android.app.Application;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

public class ExampleApplication extends Application {
    public static String registrationID;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        registrationID = JPushInterface.getRegistrationID(this);
        Log.d("TAG", "接收Registration Id : " + registrationID);
    }
}
