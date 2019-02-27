package com.spacego.myjpushtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;

public class MyJPushMessageReceiver extends JPushMessageReceiver {
    private static final String TAG = "JIGUANG-Example";

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
        Log.d(TAG, jPushMessage.toString());
        if (jPushMessage.getErrorCode() == 0) {
            Log.d(TAG, "onTagOperatorResult success.");
            Set<String > tags = jPushMessage.getTags();
            for (String tag:tags) {
                Log.d(TAG, tag);
            }
        } else {
            Log.d(TAG, "onTagOperatorResult failed.");
        }
    }

    @Override
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
        Log.d(TAG, jPushMessage.toString());
    }

    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        Log.d(TAG, jPushMessage.toString());
    }

    @Override
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);
        Log.d(TAG, jPushMessage.toString());
    }
}
