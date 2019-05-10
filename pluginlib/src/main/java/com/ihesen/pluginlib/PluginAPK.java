package com.ihesen.pluginlib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * Created by ihesen on 2019-05-06
 */
public class PluginAPK {

    public PackageInfo mPacaageInfo;
    public Resources mResources;
    public AssetManager mAssetManager;
    public DexClassLoader mDexClassLoader;

    public PluginAPK(PackageInfo packageInfo, Resources resources, DexClassLoader dexClassLoader){
        this.mPacaageInfo = packageInfo;
        this.mResources = resources;
        this.mDexClassLoader = dexClassLoader;
        this.mAssetManager = mResources.getAssets();

    }


}
