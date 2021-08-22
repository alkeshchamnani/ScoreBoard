package com.alkesh.scoreboard.presentation.screens.dashboard.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.scoreboard.common.base.viewModel.BaseViewModel
import com.alkesh.scoreboard.common.repository.GameResultsRepository
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val gameResultsRepository: GameResultsRepository) :
    BaseViewModel() {

    private val list = ArrayList<UIGameResultModel>()
    val listResults = MutableLiveData(ArrayList<UIGameResultModel>())

    init {
        getData()
    }

    private fun getResultsFromA() {
        list.clear()
        isLoading.value = true
        showMessage.value = null
        coroutineScope.launch {
            val result = gameResultsRepository.getResultFromA()
            isLoading.value = false
            result?.let {
                list.addAll(it)
                listResults.value = list
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
                list.addAll(it)
                listResults.value = list
            }
        }
    }

    fun getData() {
        list.clear()
        getResultsFromA()
        getResultsFromB()
    }
}