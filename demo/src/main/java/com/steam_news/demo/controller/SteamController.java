package com.steam_news.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.steam_news.demo.model.MergedModel;
import com.steam_news.demo.service.SteamService;


@RestController
@RequestMapping(value ="/steam_api")
public class SteamController {
   private final SteamService steamService;

    public SteamController(SteamService steamService) {
        this.steamService = steamService;
    }

    @GetMapping("top100")
    public ResponseEntity<List<MergedModel>> getPopularGames(@RequestParam(required = true, defaultValue = "0") String page, @RequestParam(required = false, defaultValue = "top100in2weeks") String request) {
        try {
            List<MergedModel> formattedJson = steamService.fetchPopularGames(request,Integer.parseInt(page));
            return ResponseEntity.ok(formattedJson);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("details")
    public ResponseEntity<MergedModel> getDetailsGame(@RequestParam(required = true, defaultValue = "0") String id) {
        try {
            MergedModel model = new MergedModel();
            MergedModel getDetails = steamService.GetDetailsGame(id, model,true);
            return ResponseEntity.ok(getDetails);
        } catch (Exception e) {
             System.err.println("Erreur lors de l'appel à l'API Steam : " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
