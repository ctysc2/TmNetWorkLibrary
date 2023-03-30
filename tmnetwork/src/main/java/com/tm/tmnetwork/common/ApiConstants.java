package com.tm.tmnetwork.common;

import android.text.TextUtils;
import android.util.Log;


import com.tm.tmnetwork.utils.NetWorkConfigUtil;

import java.util.HashMap;
import java.util.Map;

public class ApiConstants {

    //获取接口类型
    public static String getHost(String hostType) {
        String baseUrl = NetWorkConfigUtil.getBaseUrlByApiName(hostType);
        Log.i("getHost","hostType:"+hostType);
        Log.i("getHost","baseUrl:"+baseUrl);
        if(TextUtils.isEmpty(baseUrl)){
            Map<String, Object> event = new HashMap<String, Object>();
            event.put("hostType",hostType);
            baseUrl = "https://www.trialos.com";
        }
        return baseUrl;

    }


}