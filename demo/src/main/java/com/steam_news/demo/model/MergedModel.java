package com.steam_news.demo.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("MergedModel")
public class MergedModel  implements Serializable{
    private String appid;
    private String name;
    private String developer;
    private String publisher;
    private int positive;
    private int negative;
    private int ccu;
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
