package com.alkesh.scoreboard.common.models.response;

import com.alkesh.scoreboard.common.models.dto.GameResultModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetGameResultApiResponse extends BaseApiResponse {
    @SerializedName("listScores")
    @Expose
    private ArrayList<GameResultModel> listScores;

    public ArrayList<GameResultModel> getListScores() {
        return listScores;
    }

    public void setListScores(ArrayList<GameResultModel> listScores) {
        this.listScores = listScores;
    }
}