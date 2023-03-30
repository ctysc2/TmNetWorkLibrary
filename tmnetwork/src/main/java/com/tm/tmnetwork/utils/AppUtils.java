package com.tm.tmnetwork.utils;

import com.tm.tmnetwork.Const;
import com.tm.tmnetwork.app.TmsLibraryApp;

public class AppUtils {
    public static String getUrlConfig(){
        return PreferenceUtils.getPrefString(TmsLibraryApp.getInstances(), Const.KEY_URL_CONFIG,"");
    }

    public static String getAccountId(){
        return PreferenceUtils.getPrefString(TmsLibraryApp.getInstances(),Const.KEY_ACCOUNT_ID,"");
    }
}
