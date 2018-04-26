package com.sjw.utils.Util;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by androidS on 2018/4/25.
 */

public class LogUtils {
    //是否展示
    private static boolean b = true;
    private static boolean isSave = false;
    private static final String path = "/sdcard/logs/";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static String name = simpleDateFormat.format(new Date()) + "log.txt";

    public static boolean isB() {
        return b;
    }

    public static void setB(boolean b) {
        LogUtils.b = b;
    }

    public static boolean isIsSave() {
        return isSave;
    }

    public static String getPath() {
        return path;
    }

    public static void setIsSave(boolean isSave) {
        LogUtils.isSave = isSave;
    }

    public static void V(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("VERBOSE", TAG, value);
        }
    }

    public static void D(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("DEBUG", TAG, value);
        }
    }

    public static void I(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("INFO", TAG, value);
        }
    }

    public static void W(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("WARN", TAG, value);
        }
    }

    public static void E(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("ERROR", TAG, value);
        }
    }

    public static void A(String TAG, String value) {
        if (b) {
            Log.i(TAG, value);
        }
        if (isSave) {
            save("ASSERT", TAG, value);
        }
    }

    private static void save(String type, String tag, String value) {
        String time = simpleDateFormat.format(new Date());
        String s = time + " " + type + " " + tag + " " + value + "\r\n";
        try {
            writeTxtToFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeTxtToFile(String s) throws IOException {
        makeFilePath(path, name);
        String strFilePath = path + name;
        File file = new File(strFilePath);
        if (!file.exists()) {
            Log.d("TestFile", "Create the file:" + strFilePath);
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rwd");
        raf.seek(file.length());
        raf.write(s.getBytes());
        raf.close();
    }

    // 生成文件
    private static File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    // 生成文件夹
    private static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
        }
    }
}
