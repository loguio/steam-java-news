package com.steam_news.demo.model;

public class SteamModel {
    int steam_appid;
    String short_description;
    boolean is_free;
    String capsule_image;
    String website;
    int discount_percent;
    String initial_formatted;
    String final_formatted;
    
    public int getSteam_appid() {
        return steam_appid;
    }
    public void setSteam_appid(int steam_appid) {
        this.steam_appid = steam_appid;
    }
    public String getShort_description() {
        return short_description;
    }
    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
    public boolean isIs_free() {
        return is_free;
    }
    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }
    public String getCapsule_image() {
        return capsule_image;
    }
    public void setCapsule_image(String capsule_image) {
        this.capsule_image = capsule_image;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public int getDiscount_percent() {
        return discount_percent;
    }
    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }
    public String getInitial_formatted() {
        return initial_formatted;
    }
    public void setInitial_formatted(String initial_formatted) {
        this.initial_formatted = initial_formatted;
    }
    public String getFinal_formatted() {
        return final_formatted;
    }
    public void setFinal_formatted(String final_formatted) {
        this.final_formatted = final_formatted;
    }
    public String getMp4() {
        return mp4;
    }
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }
    public boolean isWindows() {
        return windows;
    }
    public void setWindows(boolean windows) {
        this.windows = windows;
    }
    public boolean isMac() {
        return mac;
    }
    public void setMac(boolean mac) {
        this.mac = mac;
    }
    public boolean isLinux() {
        return linux;
    }
    public void setLinux(boolean linux) {
        this.linux = linux;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    String mp4;
    boolean windows;
    boolean mac;
    boolean linux;
    String release_date;
    
}
