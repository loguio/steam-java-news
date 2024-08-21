package com.steam_news.demo.model;

import lombok.Data;

@Data
public class SteamspyModel {
    int appid;
    String name;
    String developer;
    String publisher;
    int positive;
    int negative;
    int ccu;
}
