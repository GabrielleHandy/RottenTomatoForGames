package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.model.Game;

import com.example.rottentomatoforgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private GameService gameService;
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/game/{gameId}")
    public Game getGameId(@PathVariable(value = "gameId")Long gameId) {
        return gameService.findByGameId(gameId);
    }
}
