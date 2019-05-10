package com.ihesen.pluginlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ihesen on 2019-05-06
 */
public interface IPlugin {

    int FROM_INTERNAL = 0;  //安装在系统中的apk
    int FROM_EXTERANL = 1;  //从外部文件获取的apk

    void attach(Activity proxyActivity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onRestart();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
