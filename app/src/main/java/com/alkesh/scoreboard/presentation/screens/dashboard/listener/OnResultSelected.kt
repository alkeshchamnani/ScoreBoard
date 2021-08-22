package com.alkesh.scoreboard.presentation.screens.dashboard.listener

import com.alkesh.scoreboard.common.uiModels.UIGameResultModel


interface OnResultSelected {
    fun onClicked(uiGameResultModel: UIGameResultModel)
}