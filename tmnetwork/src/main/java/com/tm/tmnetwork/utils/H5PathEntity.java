package com.tm.tmnetwork.utils;

import java.util.ArrayList;

public class H5PathEntity {

    ArrayList<DataEntity> pathList;

    public ArrayList<DataEntity> getPathList() {
        return pathList;
    }

    public void setPathList(ArrayList<DataEntity> pathList) {
        this.pathList = pathList;
    }

    public static class DataEntity{
        int code;
        String name;
        String path;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
