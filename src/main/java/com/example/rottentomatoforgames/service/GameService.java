package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.exception.InformationNotFoundException;
import com.example.rottentomatoforgames.model.Game;
import com.example.rottentomatoforgames.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game findByGameId(Long gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if(optionalGame.isPresent()){
            return optionalGame.get();
        }
        throw new InformationNotFoundException("Game with Id: " + gameId + " not found in database");
    }

    public Game getHighestRating() {
        return gameRepository.findTopByAverageRatingAsc();
    }
}
