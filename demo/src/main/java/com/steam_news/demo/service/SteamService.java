package com.steam_news.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steam_news.demo.model.MergedModel;

@Service
public class SteamService {
    final int countElementFor1Page = 10;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public SteamService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    // FetchPopularGames
    public List<MergedModel> fetchPopularGames(String request,int page) throws Exception {
        String urlSteamspy = "https://steamspy.com/api.php?request=" + request;
        
        // Récupérer les données de SteamSpy
        String responseBody = restTemplate.getForObject(urlSteamspy, String.class);
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        ArrayList<MergedModel> mergedModels = new ArrayList<MergedModel>();
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        
        // count for page
        int count=0;
        
        //iterer dans les 100 jeux
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String appId = field.getKey();
            JsonNode node = field.getValue();

            // Créer un modèle et le remplir avec les données de SteamSpy
            MergedModel model = new MergedModel();
            model.setAppid(node.path("appid").asText());
            model.setName(node.path("name").asText());
            model.setDeveloper(node.path("developer").asText());
            model.setPublisher(node.path("publisher").asText());
            model.setPositive(node.path("positive").asInt());
            model.setNegative(node.path("negative").asInt());
            model.setCcu(node.path("ccu").asInt());


            // Récupérer les données supplémentaires depuis l'API Steam
            if ( count >= page*countElementFor1Page && count < (page+1)*countElementFor1Page){
                //fetch API
                MergedModel newModel = GetDetailsGame(appId, model,false);
            }
            
            mergedModels.add(model);
            count+=1;
        }
    
        // return subList
        return mergedModels.subList(page*countElementFor1Page ,(page+1)*countElementFor1Page);
    }

    public MergedModel GetDetailsGame(String id, MergedModel model, boolean emptyModel) throws JsonMappingException, JsonProcessingException {
        

        String url = "https://store.steampowered.com/api/appdetails?appids=" + id;
        // Fetch API
        String steamResponse = restTemplate.getForObject(url, String.class);
        JsonNode steamJsonNode = objectMapper.readTree(steamResponse);
        JsonNode appDetailsNode = steamJsonNode.path(id).path("data");

        // mapping api into model
        if (appDetailsNode.isObject() ) {
            if (emptyModel){
                //Fetch api SPy
                String urlSpy = "https://steamspy.com/api.php?request=appdetails&appid=" + id;
                String steamResponse2 = restTemplate.getForObject(urlSpy, String.class);
                JsonNode appDetailsSpy = objectMapper.readTree(steamResponse2);

                model.setAppid(id);
                model.setName(appDetailsSpy.path("name").asText());
                model.setDeveloper(appDetailsSpy.path("developer").asText());
                model.setPublisher(appDetailsSpy.path("publisher").asText());
                model.setPositive(appDetailsSpy.path("positive").asInt());
                model.setNegative(appDetailsSpy.path("negative").asInt());
                model.setCcu(appDetailsSpy.path("ccu").asInt());

            }
            model.setShort_description(appDetailsNode.path("short_description").asText());
            model.set_free(appDetailsNode.path("is_free").asBoolean());
            model.setCapsule_image(appDetailsNode.path("header_image").asText());
            model.setWebsite(appDetailsNode.path("website").asText());
            model.setDiscount_percent(appDetailsNode.path("price_overview").path("discount_percent").asInt());
            model.setInitial_formatted(appDetailsNode.path("price_overview").path("initial_formatted").asText());
            model.setFinal_formatted(appDetailsNode.path("price_overview").path("final_formatted").asText());
            model.setMp4(appDetailsNode.path("movies").path(0).path("mp4").path("max").asText());
            model.setWindows(appDetailsNode.path("platforms").path("windows").asBoolean());
            model.setMac(appDetailsNode.path("platforms").path("mac").asBoolean());
            model.setLinux(appDetailsNode.path("platforms").path("linux").asBoolean());
            model.setRelease_date(appDetailsNode.path("release_date").path("date").asText());
        }

        return model;
    }

    public List<MergedModel> fetchDiscount(String request,int page) throws Exception {
        String urlSteamspy = "https://steamspy.com/api.php?request=" + request;
        
        // Récupérer les données de SteamSpy
        String responseBody = restTemplate.getForObject(urlSteamspy, String.class);
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        ArrayList<MergedModel> mergedModels = new ArrayList<MergedModel>();
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        
        // count for page
        int count=0;
        
        //iterer dans les 100 jeux
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String appId = field.getKey();
            JsonNode node = field.getValue();

            // Créer un modèle et le remplir avec les données de SteamSpy
            MergedModel model = new MergedModel();
            model.setAppid(node.path("appid").asText());
            model.setName(node.path("name").asText());
            model.setDeveloper(node.path("developer").asText());
            model.setPublisher(node.path("publisher").asText());
            model.setPositive(node.path("positive").asInt());
            model.setNegative(node.path("negative").asInt());
            model.setCcu(node.path("ccu").asInt());


            // Récupérer les données supplémentaires depuis l'API Steam
            if ( count >= page*countElementFor1Page && count < (page+1)*countElementFor1Page){
                //fetch API
                MergedModel newModel = GetDetailsGame(appId, model,false);
            }
            // if(node.path(""))
            mergedModels.add(model);
            count+=1;
        }
    
        // return subList
        return mergedModels.subList(page*countElementFor1Page ,(page+1)*countElementFor1Page);
    }
}
