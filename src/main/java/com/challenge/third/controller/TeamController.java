package com.challenge.third.controller;

import com.challenge.third.model.Team;
import com.challenge.third.service.TeamService;
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
@RequestMapping("/team")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ArrayList<Team> findAll() {
        return teamService.findAll();
    }

    @PostMapping
    public Team save(@RequestBody Team team) {
        return teamService.save(team);
    }

}
