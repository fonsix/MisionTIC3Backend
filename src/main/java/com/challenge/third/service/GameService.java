package com.challenge.third.service;

import com.challenge.third.model.Game;
import com.challenge.third.repository.GameRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public ArrayList<Game> findAll() {
        return (ArrayList<Game>) gameRepository.findAll();
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

}
