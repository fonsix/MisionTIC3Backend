package com.challenge.third.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private int localTeamId;
    @Column(nullable = false)
    private int guestTeamId;
    @Column(nullable = false)
    private short localTeamScore;
    @Column(nullable = false)
    private short guestTeamScore;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocalTeamId() {
        return localTeamId;
    }

    public void setLocalTeamId(int localTeamId) {
        this.localTeamId = localTeamId;
    }

    public int getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(int guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public short getLocalTeamScore() {
        return localTeamScore;
    }

    public void setLocalTeamScore(short localTeamScore) {
        this.localTeamScore = localTeamScore;
    }

    public short getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(short guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
