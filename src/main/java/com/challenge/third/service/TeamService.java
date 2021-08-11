package com.challenge.third.service;

import com.challenge.third.model.Team;
import com.challenge.third.repository.TeamRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public ArrayList<Team> findAll() {
        return (ArrayList<Team>) teamRepository.findAll();
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

}
