package com.alkesh.scoreboard.core.network.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GameResultDTO implements Serializable {
    @SerializedName("Team_A")
    @Expose
    private String teamA;
    @SerializedName("Team_B")
    @Expose
    private String teamB;
    @SerializedName("Score")
    @Expose
    private String score;
    @SerializedName("link_A")
    @Expose
    private String linkA;
    @SerializedName("link_B")
    @Expose
    private String linkB;
    @SerializedName("Date")
    @Expose
    private String date;

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