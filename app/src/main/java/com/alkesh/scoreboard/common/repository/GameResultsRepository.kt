package com.alkesh.scoreboard.common.repository

import com.alkesh.scoreboard.common.base.repository.BaseRepository
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.dataSources.database.dao.DaoGameResult
import com.alkesh.scoreboard.dataSources.mapper.GameResultsMapper
import com.alkesh.scoreboard.dataSources.network.services.GameResultsService
import javax.inject.Inject


class GameResultsRepository @Inject constructor(
    private val gameResultsService: GameResultsService,
    private val daoGameResult: DaoGameResult,
    private val gameResultsMapper: GameResultsMapper
) : BaseRepository() {

    suspend fun getResultFromA(): ArrayList<UIGameResultModel>? {
        val list = ArrayList<UIGameResultModel>()
        try {
            val response = gameResultsService.getResultsFromA()
            if (response.isSuccessful) {
                daoGameResult.deleteAll(APISource.APIA.value)
                val result = response.body()
                result?.let {
                    for (dto in it) {
                        val uiModel = gameResultsMapper.convertDtoIntoUIModel(dto)
                        uiModel?.let {
                            list.add(it)
                        }
                        val dbModel =
                            gameResultsMapper.convertDtoIntoDbModel(dto, APISource.APIA.value)
                        daoGameResult.insertAll(dbModel)
                    }
                }
            } else {
                list.addAll(getDBModelsAndThenConvertIntoUIModels(APISource.APIA.value))
            }
        } catch (exp: Exception) {
            list.addAll(getDBModelsAndThenConvertIntoUIModels(APISource.APIA.value))
        }
        return list
    }

    suspend fun getResultFromB(): ArrayList<UIGameResultModel>? {
        val list = ArrayList<UIGameResultModel>()
        try {
            val response = gameResultsService.getResultsFromB()
            if (response.isSuccessful) {
                daoGameResult.deleteAll(APISource.APIB.value)
                val result = response.body()
                result?.let {
                    for (dto in it) {
                        val uiModel = gameResultsMapper.convertDtoIntoUIModel(dto)
                        uiModel?.let {
                            list.add(it)
                        }
                        val dbModel =
                            gameResultsMapper.convertDtoIntoDbModel(dto, APISource.APIB.value)
                        daoGameResult.insertAll(dbModel)
                    }
                }
            } else {
                list.addAll(getDBModelsAndThenConvertIntoUIModels(APISource.APIB.value))
            }
        } catch (exp: Exception) {
            list.addAll(getDBModelsAndThenConvertIntoUIModels(APISource.APIB.value))
        }
        return list
    }

    private suspend fun getDBModelsAndThenConvertIntoUIModels(apiSource: String): ArrayList<UIGameResultModel> {
        val list = ArrayList<UIGameResultModel>()
        val listDBModels = daoGameResult.getAll(APISource.APIA.value)
        for (dbModel in listDBModels) {
            val uiModel = gameResultsMapper.convertDbModelIntoUIModel(dbModel)
            uiModel?.let {
                list.add(it)
            }
        }
        return list
    }

    enum class APISource(var value: String) {
        APIA("APIA"),
        APIB("APIB")
    }
}

