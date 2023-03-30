package com.tm.tmnetwork.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tm.tmnetwork.Const;
import com.tm.tmnetwork.app.TmsLibraryApp;
import com.tm.tmnetwork.entity.ApiConfigEntity;
import com.tm.tmnetwork.entity.HostConfigEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//读取网络请求配置json的工具类
public class NetWorkConfigUtil {

    //启动时从asset文件读取并保存至偏好设置，增加读取速度
    public static void init(Context context){
        String hostJson = getFromAssets("hostConfig.json",context);
        String apiJson = getFromAssets("apiConfig.json",context);
        String h5PathJson = getFromAssets("h5Path.json",context);
        try {
            if(!TextUtils.isEmpty(hostJson)){
                HostConfigEntity hostConfigEntity = new Gson().fromJson(hostJson,new TypeToken<HostConfigEntity>(){}.getType());
                PreferenceUtils.setPrefObject(context, Const.KEY_HOST_CONFIG,hostConfigEntity);
            }else{

            }
            if(!TextUtils.isEmpty(apiJson)){
                ApiConfigEntity apiConfigEntity = new Gson().fromJson(apiJson,new TypeToken<ApiConfigEntity>(){}.getType());
                PreferenceUtils.setPrefObject(context, Const.KEY_API_CONFIG,apiConfigEntity);
            }else{

            }
            if(!TextUtils.isEmpty(h5PathJson)){
                H5PathEntity h5PathEntity = new Gson().fromJson(h5PathJson,new TypeToken<H5PathEntity>(){}.getType());
                PreferenceUtils.setPrefObject(context, Const.KEY_H5_PATH_CONFIG,h5PathEntity);
            }else{

            }
        }catch (Exception e){

        }

    }




    public static String getUrl(String name){
        ApiConfigEntity apiConfigEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_API_CONFIG,ApiConfigEntity.class);
        if(apiConfigEntity != null && apiConfigEntity.getUrlList() != null && apiConfigEntity.getUrlList().size() > 0){
            for(int i = 0;i<apiConfigEntity.getUrlList().size();i++){
                ApiConfigEntity.DataEntity apiEntity = apiConfigEntity.getUrlList().get(i);
                if(name.equals(apiEntity.getName())){
                    return  apiEntity.getPath();
                }
            }
        }
        return "";
    }

    //是否需要缓存
    public static boolean isLoadCache(String name){
        ApiConfigEntity apiConfigEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_API_CONFIG,ApiConfigEntity.class);
        if(apiConfigEntity != null && apiConfigEntity.getUrlList() != null && apiConfigEntity.getUrlList().size() > 0){
            for(int i = 0;i<apiConfigEntity.getUrlList().size();i++){
                ApiConfigEntity.DataEntity apiEntity = apiConfigEntity.getUrlList().get(i);
                if(apiEntity.getName().equals(name)){
                    return apiEntity.isCache();
                }
            }
        }

        return false;
    }

    public static String getH5Path(int code){
        H5PathEntity h5PathEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_H5_PATH_CONFIG,H5PathEntity.class);
        if(h5PathEntity != null && h5PathEntity.getPathList() != null && h5PathEntity.getPathList().size() > 0){
            for(int i = 0;i<h5PathEntity.getPathList().size();i++){
                H5PathEntity.DataEntity dataEntity = h5PathEntity.getPathList().get(i);
                if(dataEntity.getCode() == code){
                    return dataEntity.getPath();
                }
            }
        }
        return "";
    }

    public static String getBaseUrlByHostName(String name){
        HostConfigEntity hostConfigEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_HOST_CONFIG,HostConfigEntity.class);
        if(hostConfigEntity != null){
            for(int j = 0;j<hostConfigEntity.getDomainList().size();j++){
                HostConfigEntity.DataEntity hostEntity = hostConfigEntity.getDomainList().get(j);
                if(hostEntity.getName().equals(name)){
                    String env = PreferenceUtils.getPrefString(TmsLibraryApp.getInstances(),Const.KEY_ENVIRMENT,"uat");
                    if(TmsLibraryApp.getEnv().equals("product")){
                        return AppUtils.getUrlConfig();
                    }else{
                        switch (env){
                            case "test":
                                return  hostEntity.getTest();
                            case "uat":
                            default:
                                return  hostEntity.getUat();


                        }
                    }

                }
            }
        }
        return  "";

    }

    public static String getBaseUrlByApiName(String name){

        HostConfigEntity hostConfigEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_HOST_CONFIG,HostConfigEntity.class);
        ApiConfigEntity apiConfigEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_API_CONFIG,ApiConfigEntity.class);

        if(apiConfigEntity != null){
            if(apiConfigEntity.getUrlList() != null && apiConfigEntity.getUrlList().size() > 0){
                for(int i = 0;i<apiConfigEntity.getUrlList().size();i++){
                    ApiConfigEntity.DataEntity apiEntity = apiConfigEntity.getUrlList().get(i);

                    if(apiEntity.getName().equals(name) && hostConfigEntity != null && hostConfigEntity.getDomainList() != null){
                        for(int j = 0;j<hostConfigEntity.getDomainList().size();j++){
                            HostConfigEntity.DataEntity hostEntity = hostConfigEntity.getDomainList().get(j);
                            if(hostEntity.getName().equals(apiEntity.getApp())){
                                String env = PreferenceUtils.getPrefString(TmsLibraryApp.getInstances(),Const.KEY_ENVIRMENT,"uat");
                                if(TmsLibraryApp.getEnv().equals("product")){
                                    return  AppUtils.getUrlConfig();
                                }else{
                                    switch (env){
                                        case "test":
                                            return  hostEntity.getTest();
                                        case "uat":
                                        default:
                                            return  hostEntity.getUat();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }


    //读取本地配置的json
    public static String getFromAssets(String fileName, Context context){
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName) );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String Result="";
            while((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  "";
    }

    public static String getH5UrlByCode(int code){
        H5PathEntity.DataEntity dataEntityWithCode = null;
        H5PathEntity h5PathEntity = PreferenceUtils.getPrefObject(TmsLibraryApp.getInstances(),Const.KEY_H5_PATH_CONFIG,H5PathEntity.class);
        if(h5PathEntity != null && h5PathEntity.getPathList() != null && h5PathEntity.getPathList().size() > 0){
            for(int i = 0;i<h5PathEntity.getPathList().size();i++){
                H5PathEntity.DataEntity dataEntity = h5PathEntity.getPathList().get(i);
                if(dataEntity.getCode() == code){
                    dataEntityWithCode = dataEntity;
                    break;
                }
            }
        }
        if(dataEntityWithCode == null){
            return "";
        }else{
            String host = NetWorkConfigUtil.getBaseUrlByHostName("trialOS");
            return host + dataEntityWithCode.getPath();
        }

    }

}
