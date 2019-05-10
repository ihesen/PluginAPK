package com.ihesen.pluginapk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ihesen.pluginlib.PluginManager;
import com.ihesen.pluginlib.ProxyActivity;

/**
 * Created by ihesen on 2019-05-06
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PluginManager.getInstance().init(this);

        findViewById(R.id.tv_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apkPath = Utils.copyAssetAndWrite(MainActivity.this, "aa.apk");
                PluginManager.getInstance().loadApk(apkPath);
            }
        });

        findViewById(R.id.tv_forword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ProxyActivity.class);
                intent.putExtra("className", "com.ihesen.nepluginapk.NepluginActivity");
                startActivity(intent);
            }
        });
    }
}
