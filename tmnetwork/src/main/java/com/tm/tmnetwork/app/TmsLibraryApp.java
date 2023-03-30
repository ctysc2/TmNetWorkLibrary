package com.tm.tmnetwork.app;

import android.content.Context;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class TmsLibraryApp {

    private static Context context;

    //当前编译环境
    private static String env;

    //当前环境下的报名
    private static String applicationId;


    private static String versionName;

    private static int versionCode;

    //预初始化，app启动时初始化sdk所需的必要参数
    public static void preInit(Context context,String env,String applicationId,String versionName,int versionCode){
        TmsLibraryApp.context = context;
        TmsLibraryApp.env = env;
        TmsLibraryApp.applicationId = applicationId;
        TmsLibraryApp.versionName = versionName;
        TmsLibraryApp.versionCode = versionCode;
    }



    public static OkHttpClient getUnsafeOkHttpClient() {

        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);

            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static Context getInstances(){
        return context;
    }

    public static String getEnv(){
        return env;
    }

    public static String getApplicationId(){
        return applicationId;
    }

    public static String getVersionName(){
        return versionName;
    }

    public static int getVersionCode(){
        return versionCode;
    }

}
