package com.alkesh.scoreboard.common.uiModels;

import java.io.Serializable;

public class UIGameResultModel implements Serializable {

    private String teamA;
    private String teamB;
    private String score;
    private String linkA;
    private String linkB;
    private String date;

    public UIGameResultModel(String teamA, String teamB, String score, String linkA, String linkB, String date) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.score = score;
        this.linkA = linkA;
        this.linkB = linkB;
        this.date = date;
    }

    public UIGameResultModel() {

    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLinkA() {
        return linkA;
    }

    public void setLinkA(String linkA) {
        this.linkA = linkA;
    }

    public String getLinkB() {
        return linkB;
    }

    public void setLinkB(String linkB) {
        this.linkB = linkB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}