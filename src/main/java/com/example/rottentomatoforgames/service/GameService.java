package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.model.Game;
import com.example.rottentomatoforgames.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
