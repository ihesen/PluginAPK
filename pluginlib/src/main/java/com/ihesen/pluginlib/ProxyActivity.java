package com.ihesen.pluginlib;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

/**
 * Created by ihesen on 2019-05-06
 * 代理Activity，管理Activity的生命周期
 */
public class ProxyActivity extends Activity {

    private String mClassName;
    private PluginAPK mPluginAPK;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mClassName = getIntent().getStringExtra("className");
        mPluginAPK = PluginManager.getInstance().getPluginAPK();


        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if (mPluginAPK == null) {
            throw new RuntimeException("Loading your apk file frist please!");
        }
        try {
            Class<?> clazz = mPluginAPK.mDexClassLoader.loadClass(mClassName);
            Object object = clazz.newInstance();
            if (object instanceof IPlugin) {
                mIPlugin = (IPlugin) object;
                mIPlugin.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPlugin.FROM_EXTERANL);
                mIPlugin.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Resources getResources() {
        return mPluginAPK != null ? mPluginAPK.mResources : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginAPK != null ? mPluginAPK.mAssetManager : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginAPK != null ? mPluginAPK.mDexClassLoader : super.getClassLoader();
    }


}
