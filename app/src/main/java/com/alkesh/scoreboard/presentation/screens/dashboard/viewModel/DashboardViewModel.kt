package com.alkesh.scoreboard.presentation.screens.dashboard.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.scoreboard.common.base.viewModel.BaseViewModel
import com.alkesh.scoreboard.common.models.dto.GameResultModel
import com.alkesh.scoreboard.common.repository.GameResultsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val gameResultsRepository: GameResultsRepository) :
    BaseViewModel() {

    private val list = ArrayList<GameResultModel>()
    val listResults = MutableLiveData(ArrayList<GameResultModel>())

    init {
        getResultsFromA()
    }

    private fun getResultsFromA() {
        list.clear()
        isLoading.value = true
        showMessage.value = null
        coroutineScope.launch {
            val result = gameResultsRepository.getResultFromA()
            isLoading.value = false
            result?.let {
                if (it.successful) {
                    list.addAll(result.listScores)
                    getResultsFromB()
                } else {
                    showMessage.value = result.message
                }
            }
        }
    }

    private fun getResultsFromB() {
        isLoading.value = true
        showMessage.value = null
        coroutineScope.launch {
            val result = gameResultsRepository.getResultFromB()
            isLoading.value = false
            result?.let {
                if (it.successful) {
                    list.addAll(result.listScores)
                    listResults.value = list
                } else {
                    showMessage.value = result.message
                }
            }
        }
    }
}