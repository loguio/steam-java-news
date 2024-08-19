package com.steam_news.demo.model;

import lombok.Data;

@Data
public class MergedModel {
    private int appid;
    private String name;
    private String developer;
    private String publisher;
    private int positive;
    private int negative;
    private int ccu;
    private int steam_appid;
    private String short_description;
    private boolean is_free;
    private String capsule_image;
    private String website;
    private int discount_percent;
    private String initial_formatted;
    private String final_formatted;
    private String mp4;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private String release_date;
}
