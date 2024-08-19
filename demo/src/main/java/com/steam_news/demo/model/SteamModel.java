package com.steam_news.demo.model;

import lombok.Data;

@Data
public class SteamModel {
    String short_description;
    boolean is_free;
    String capsule_image;
    String website;
    int discount_percent;
    String initial_formatted;
    String final_formatted;
    String mp4;
    boolean windows;
    boolean mac;
    boolean linux;
    String release_date;
    
}
