package com.alkesh.scoreboard.presentation.screens.score.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.scoreboard.common.base.viewModel.BaseViewModel
import com.alkesh.scoreboard.common.models.dto.GameResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultDetailViewModel @Inject constructor() : BaseViewModel() {
    val gameResultModel = MutableLiveData<GameResultModel>()
    val readDataFromBundle = MutableLiveData<Boolean>()

    init {
        readDataFromBundle.value = true
    }

    fun setResults(model: GameResultModel) {
        gameResultModel.value = model
    }
}