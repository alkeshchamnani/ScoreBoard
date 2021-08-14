package com.alkesh.scoreboard.common.repository

import com.alkesh.scoreboard.common.base.repository.BaseRepository
import com.alkesh.scoreboard.common.models.response.GetGameResultApiResponse
import com.alkesh.scoreboard.core.network.services.GameResultsService
import javax.inject.Inject


class GameResultsRepository @Inject constructor(
    private val gameResultsService: GameResultsService
) : BaseRepository() {

    suspend fun getResultFromA(): GetGameResultApiResponse? {
        val model =
            GetGameResultApiResponse()
        try {
            val response = gameResultsService.getResultsFromA()
            if (response.isSuccessful) {
                model.listScores = response.body()
                model.successful = true
            }
        } catch (exp: Exception) {
            model.let {
                it.successful = false
                it.message = exp.message
            }
        }
        return model
    }

    suspend fun getResultFromB(): GetGameResultApiResponse? {
        val model =
            GetGameResultApiResponse()
        try {
            val response = gameResultsService.getResultsFromB()
            if (response.isSuccessful) {
                model.listScores = response.body()
                model.successful = true
            }
        } catch (exp: Exception) {
            model.let {
                it.successful = false
                it.message = exp.message
            }
        }
        return model
    }

}