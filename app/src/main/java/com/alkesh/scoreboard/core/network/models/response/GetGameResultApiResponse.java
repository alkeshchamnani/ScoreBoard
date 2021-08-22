package com.alkesh.scoreboard.core.network.models.response;

import com.alkesh.scoreboard.core.network.models.dto.GameResultDTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetGameResultApiResponse extends BaseApiResponse {
    @SerializedName("listScores")
    @Expose
    private ArrayList<GameResultDTO> listScores;

    public ArrayList<GameResultDTO> getListScores() {
        return listScores;
    }

    public void setListScores(ArrayList<GameResultDTO> listScores) {
        this.listScores = listScores;
    }
}