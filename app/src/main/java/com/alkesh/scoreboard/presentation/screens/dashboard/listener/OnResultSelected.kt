package com.alkesh.scoreboard.presentation.screens.dashboard.listener

import com.alkesh.scoreboard.common.models.dto.GameResultModel


interface OnResultSelected {
    fun onClicked(model: GameResultModel)
}