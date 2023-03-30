package com.tm.tmnetwork.entity;

import java.util.ArrayList;

public class ApiConfigEntity {

    ArrayList<DataEntity> urlList;

    public ArrayList<DataEntity> getUrlList() {
        return urlList;
    }

    public void setUrlList(ArrayList<DataEntity> urlList) {
        this.urlList = urlList;
    }

    public static class DataEntity{
        String name;
        String app;
        String path;
        String method;
        boolean isCache;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public boolean isCache() {
            return isCache;
        }

        public void setCache(boolean cache) {
            isCache = cache;
        }
    }
}
