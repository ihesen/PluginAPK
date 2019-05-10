package com.ihesen.pluginapk;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Utils {


//    public static String copyAssetAndWrite(Context context, String name) {
//        InputStream in = null;
//        FileOutputStream out = null;
//        String path = "/data/data/" + context.getPackageName();
//        File file = new File(path + "/" + name);
//        try {
//            //创建文件夹
//            File file_ = new File(path);
//            if (!file_.exists())
//                file_.mkdirs();
//            if (file.exists())//删除已经存在的
//                file.deleteOnExit();
//            //创建新的文件
//            if (!file.exists())
//                file.createNewFile();
//
//            in = context.getAssets().open(name); // 从assets目录下复制
//            out = new FileOutputStream(file);
//            int length = -1;
//            byte[] buf = new byte[1024];
//            while ((length = in.read(buf)) != -1) {
//                out.write(buf, 0, length);
//            }
//            out.flush();
//            Toast.makeText(context, "load file success", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) in.close();
//                if (out != null) out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
//        return path + "/" + name;
//    }

    /**
     * 将file拷贝到data目录下
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String copyAssetAndWrite(Context context, String fileName) {
        try {
            File cacheDir = context.getCacheDir();
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File outFile = new File(cacheDir, fileName);
            if (!outFile.exists()) {
                boolean res = outFile.createNewFile();
                if (res) {
                    InputStream is = context.getAssets().open(fileName);
                    FileOutputStream fos = new FileOutputStream(outFile);
                    byte[] buffer = new byte[is.available()];
                    int byteCount;
                    while ((byteCount = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, byteCount);
                    }
                    fos.flush();
                    is.close();
                    fos.close();
                    Toast.makeText(context, "下载成功", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "文件已经存在", Toast.LENGTH_SHORT).show();
            }
            return outFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
