package com.tm.tmnetwork.entity;

import java.util.ArrayList;

public class HostConfigEntity {

    ArrayList<DataEntity> domainList;

    public ArrayList<DataEntity> getDomainList() {
        return domainList;
    }

    public void setDomainList(ArrayList<DataEntity> domainList) {
        this.domainList = domainList;
    }

    public static class DataEntity{
        String name;
        String dev;
        String test;
        String uat;
        String demo;
        String product;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDev() {
            return dev;
        }

        public void setDev(String dev) {
            this.dev = dev;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public String getUat() {
            return uat;
        }

        public void setUat(String uat) {
            this.uat = uat;
        }

        public String getDemo() {
            return demo;
        }

        public void setDemo(String demo) {
            this.demo = demo;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }
    }
}
