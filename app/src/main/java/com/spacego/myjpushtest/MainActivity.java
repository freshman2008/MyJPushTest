package com.spacego.myjpushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mStopPushBtn;
    private Button mResumePushBtn;
    private Button mSetAliasBtn;
    private Button mSetTagBtn;
    private Button mGetAliasBtn;
    private Button mGetTagBtn;
    private Button mAddTagBtn;
    private Button mSetMobileBtn;
    private EditText mAliasEdt;
    private EditText mTagEdt;
    private EditText mMobileEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // 初始化按钮
    private void initView() {
        mStopPushBtn = (Button)findViewById(R.id.stopPush);
        mStopPushBtn.setOnClickListener(this);

        mResumePushBtn = (Button)findViewById(R.id.resumePush);
        mResumePushBtn.setOnClickListener(this);

        mSetAliasBtn = (Button)findViewById(R.id.setAlias);
        mSetAliasBtn.setOnClickListener(this);

        mSetTagBtn = (Button)findViewById(R.id.setTag);
        mSetTagBtn.setOnClickListener(this);

        mGetAliasBtn = (Button)findViewById(R.id.getAlias);
        mGetAliasBtn.setOnClickListener(this);

        mGetTagBtn = (Button)findViewById(R.id.getTag);
        mGetTagBtn.setOnClickListener(this);

        mAddTagBtn = (Button)findViewById(R.id.addTag);
        mAddTagBtn.setOnClickListener(this);

        mSetMobileBtn = (Button)findViewById(R.id.setMobile);
        mSetMobileBtn.setOnClickListener(this);

        mAliasEdt = findViewById(R.id.aliasText);
        mTagEdt = findViewById(R.id.tagText);
        mMobileEdt = findViewById(R.id.mobileText);
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

            case R.id.setAlias:
//                JPushInterface.setAlias(getApplicationContext(), 1001, mAliasEdt.getText().toString());
                JPushInterface.setAlias(getApplicationContext(), mAliasEdt.getText().toString(), new TagAliasCallback() {

                    @Override
                    public void gotResult(int i, String s, Set<String> set) {
                        Log.v("hello", "alias:" + s);
                    }
                });
                break;

            case R.id.addTag:
                {
                    Set<String> tags = new HashSet<>();
                    tags.add(mTagEdt.getText().toString());
                    JPushInterface.addTags(getApplicationContext(), 1001, tags);
                }
                break;
            case R.id.setTag:
                {
                    Set<String> tags = new HashSet<>();
                    tags.add(mTagEdt.getText().toString());
                    JPushInterface.setTags(getApplicationContext(), 1001, tags);
                    JPushInterface.setTags(getApplicationContext(), tags, new TagAliasCallback() {
                        @Override
                        public void gotResult(int i, String s, Set<String> set) {
                            for (String tag:set) {
                                Log.v("hello", "tag:" + tag);
                            }
                        }
                    });
                }
                break;

            case R.id.getAlias:
                JPushInterface.getAllTags(getApplicationContext(), 1001);
                break;

            case R.id.getTag:
                JPushInterface.getAlias(getApplicationContext(), 1001);
                break;

            case R.id.setMobile:
                JPushInterface.setMobileNumber(getApplicationContext(), 1001, mMobileEdt.getText().toString());
                break;
        }
    }
}
