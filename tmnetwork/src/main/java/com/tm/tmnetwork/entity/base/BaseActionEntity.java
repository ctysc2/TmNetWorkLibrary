package com.tm.tmnetwork.entity.base;

import java.util.ArrayList;

public class BaseActionEntity {
    String action;
    DataEntity data;

    public static class DataEntity{
        String message;
        String vipCardId;
        String vipCardName;
        String categoryId;
        String accountId;
        String eventID;
        int eventValue;
        String url;
        String title;
        String text;
        String img;
        String name;
        String type;
        String source;
        int maxCount;
        boolean isCamera;
        String callBackId;
        String scanType;
        int index;
        ArrayList imgs;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ArrayList getImgs() {
            return imgs;
        }

        public void setImgs(ArrayList imgs) {
            this.imgs = imgs;
        }

        public String getScanType() {
            return scanType;
        }

        public void setScanType(String scanType) {
            this.scanType = scanType;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getCallBackId() {
            return callBackId;
        }

        public void setCallBackId(String callBackId) {
            this.callBackId = callBackId;
        }

        public int getMaxCount() {
            return maxCount;
        }

        public void setMaxCount(int maxCount) {
            this.maxCount = maxCount;
        }

        public boolean isCamera() {
            return isCamera;
        }

        public void setCamera(boolean camera) {
            isCamera = camera;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEventID() {
            return eventID;
        }

        public void setEventID(String eventID) {
            this.eventID = eventID;
        }

        public int getEventValue() {
            return eventValue;
        }

        public void setEventValue(int eventValue) {
            this.eventValue = eventValue;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getVipCardId() {
            return vipCardId;
        }

        public void setVipCardId(String vipCardId) {
            this.vipCardId = vipCardId;
        }

        public String getVipCardName() {
            return vipCardName;
        }

        public void setVipCardName(String vipCardName) {
            this.vipCardName = vipCardName;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
