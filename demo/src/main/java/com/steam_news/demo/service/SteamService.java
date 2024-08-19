package com.steam_news.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SteamService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public SteamService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    // FetchPopularGames
    public String fetchPopularGames(String request) throws Exception {
        String url = "https://steamspy.com/api.php?request=" + request;
        
        // Effectuer la requête GET
        String responseBody = restTemplate.getForObject(url, String.class);
        
        // Parser et formater le JSON
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        System.out.println(jsonNode.get("570").get("name"));
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
    }

    public String GetDetailsGame(int id) {
        String url = "https://store.steampowered.com/api/appdetails?appids=" + id;

        String responseBody = restTemplate.getForObject(url, String.class);

        return responseBody;
    }
}
