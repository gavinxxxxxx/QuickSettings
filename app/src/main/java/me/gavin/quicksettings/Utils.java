package me.gavin.quicksettings;

import android.content.Context;
import android.content.pm.PackageManager;

public class Utils {

    /**
     * 判断某应用是否安装
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
