package com.ihesen.nepluginapk;

import android.os.Bundle;

import com.ihesen.pluginlib.PluginActivity;

/**
 * Created by ihesen on 2019-05-06
 * 插件activity
 */
public class NepluginActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_ne_plugin);
    }
}
