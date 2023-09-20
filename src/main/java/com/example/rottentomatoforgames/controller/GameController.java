package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private GameService gameService;
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
