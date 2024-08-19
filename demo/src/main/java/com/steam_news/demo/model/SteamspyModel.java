package com.steam_news.demo.model;


public class SteamspyModel {
    int appid;
    String name;
    String developer;
    String publisher;
    int positive;
    int negative;
    int ccu;
    
    public int getAppid() {
        return appid;
    }
    public void setAppid(int appid) {
        this.appid = appid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getPositive() {
        return positive;
    }
    public void setPositive(int positive) {
        this.positive = positive;
    }
    public int getNegative() {
        return negative;
    }
    public void setNegative(int negative) {
        this.negative = negative;
    }
    public int getCcu() {
        return ccu;
    }
    public void setCcu(int ccu) {
        this.ccu = ccu;
    }
    
}
