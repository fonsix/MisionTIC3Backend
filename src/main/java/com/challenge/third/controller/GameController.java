package com.challenge.third.controller;

import com.challenge.third.model.Game;
import com.challenge.third.service.GameService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ArrayList<Game> findAll() {
        return gameService.findAll();
    }

    @PostMapping
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

}
