package com.steam_news.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.steam_news.demo.service.SteamService;


@RestController
@RequestMapping(value ="/steam_api")
public class SteamController {
   private final SteamService steamService;

    public SteamController(SteamService steamService) {
        this.steamService = steamService;
    }

    @GetMapping("top100")
    public ResponseEntity<String> getPopularGames(@RequestParam(required = false, defaultValue = "top100in2weeks") String request) {
        try {
            String formattedJson = steamService.fetchPopularGames(request);
            return ResponseEntity.ok(formattedJson);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à l'API Steam : " + e.getMessage());
            return ResponseEntity.status(500).body("Erreur lors de la récupération des données de l'API Steam.");
        }
    }

    @GetMapping("details")
    public ResponseEntity<String> getDetailsGame(int id) {
        return null;
        // try {
        //     String getDetails = steamService.GetDetailsGame(id);
        //     return getDetails;
        // } catch (Exception e) {
        //      System.err.println("Erreur lors de l'appel à l'API Steam : " + e.getMessage());
        //     return ResponseEntity.status(500).body("Erreur lors de la récupération des données de l'API Steam.");
        // }
    }
}
