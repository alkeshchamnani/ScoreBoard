package com.alkesh.scoreboard.core.network.services

import com.alkesh.scoreboard.core.network.models.dto.GameResultDTO
import retrofit2.Response
import retrofit2.http.GET


interface GameResultsService {
    @GET("v3/23745f3a-5eaa-43cf-ab46-737eb273596b")
    suspend fun getResultsFromA(): Response<ArrayList<GameResultDTO>>

    @GET("v3/bc1ce3b7-6ad2-4fef-af6c-08f8865b210e")
    suspend fun getResultsFromB(): Response<ArrayList<GameResultDTO>>

}