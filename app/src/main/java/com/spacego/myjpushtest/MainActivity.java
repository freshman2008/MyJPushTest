package com.spacego.myjpushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mStopPush;
    private Button mResumePush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // 初始化按钮
    private void initView() {
        mStopPush = (Button)findViewById(R.id.stopPush);
        mStopPush.setOnClickListener(this);

        mResumePush = (Button)findViewById(R.id.resumePush);
        mResumePush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // 点击停止按钮后，极光推送服务会被停止掉
            case R.id.stopPush:
                JPushInterface.stopPush(getApplicationContext());
                break;

            // 点击恢复按钮后，极光推送服务会恢复正常工作
            case R.id.resumePush:
                JPushInterface.resumePush(getApplicationContext());
                break;
        }
    }
}
