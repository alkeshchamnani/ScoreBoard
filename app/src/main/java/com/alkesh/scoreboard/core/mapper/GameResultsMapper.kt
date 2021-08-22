package com.alkesh.scoreboard.core.mapper

import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.core.database.entity.DbGameResult
import com.alkesh.scoreboard.core.network.models.dto.GameResultDTO
import javax.inject.Inject

class GameResultsMapper  {
    fun convertDtoIntoUIModel(dto: GameResultDTO?): UIGameResultModel? {
        var uiModel: UIGameResultModel? = null

        dto?.let {
            uiModel = UIGameResultModel(
                dto.teamA,
                dto.teamB,
                dto.score,
                dto.linkA,
                dto.linkB,
                dto.date
            )
        }
        return uiModel
    }

    fun convertDbModelIntoUIModel(dbModel: DbGameResult?): UIGameResultModel? {
        var uiModel: UIGameResultModel? = null
        dbModel?.let {
            uiModel =
                UIGameResultModel(
                    dbModel.teamA,
                    dbModel.teamB,
                    dbModel.score,
                    dbModel.linkA,
                    dbModel.linkB,
                    dbModel.date
                )
        }
        return uiModel
    }

    fun convertDtoIntoDbModel(dto: GameResultDTO, apiSource: String): DbGameResult {
        return DbGameResult(
            null,
            dto.teamA,
            dto.teamB,
            dto.score,
            dto.linkA,
            dto.linkB,
            dto.date,
            apiSource
        )
    }
}