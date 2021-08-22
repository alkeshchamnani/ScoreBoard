package com.alkesh.scoreboard.common.repository

import com.alkesh.scoreboard.common.base.repository.BaseRepository
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import javax.inject.Inject


class GameResultsRepository @Inject constructor(
   // private val gameResultsService: GameResultsService,
   // private val daoGameResult: DaoGameResult,
    //private val gameResultsMapper: GameResultsMapper
) : BaseRepository() {

    suspend fun getResultFromA(): ArrayList<UIGameResultModel>? {
        val list = ArrayList<UIGameResultModel>()
        /*try {
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
                val listDBModels = daoGameResult.getAll(APISource.APIA.value)
                for (dbModel in listDBModels) {
                    val uiModel = gameResultsMapper.convertDbModelIntoUIModel(dbModel)
                    uiModel?.let {
                        list.add(it)
                    }
                }
            }
        } catch (exp: Exception) {
            val listDBModels = daoGameResult.getAll(APISource.APIA.value)
            for (dbModel in listDBModels) {
                val uiModel = gameResultsMapper.convertDbModelIntoUIModel(dbModel)
                uiModel?.let {
                    list.add(it)
                }
            }
        }*/
        return list
    }

    suspend fun getResultFromB(): ArrayList<UIGameResultModel>? {
        val list = ArrayList<UIGameResultModel>()
       /* try {
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
                val listDBModels = daoGameResult.getAll(APISource.APIB.value)
                for (dbModel in listDBModels) {
                    val uiModel = gameResultsMapper.convertDbModelIntoUIModel(dbModel)
                    uiModel?.let {
                        list.add(it)
                    }
                }
            }
        } catch (exp: Exception) {
            val listDBModels = daoGameResult.getAll(APISource.APIB.value)
            for (dbModel in listDBModels) {
                val uiModel = gameResultsMapper.convertDbModelIntoUIModel(dbModel)
                uiModel?.let {
                    list.add(it)
                }
            }
        }*/
        return list
    }


    enum class APISource(var value: String) {
        APIA("APIA"),
        APIB("APIB")
    }
}