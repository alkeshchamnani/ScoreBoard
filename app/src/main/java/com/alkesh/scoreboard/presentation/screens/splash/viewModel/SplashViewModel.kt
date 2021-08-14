package com.alkesh.scoreboard.presentation.screens.splash.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.alkesh.scoreboard.common.base.viewModel.BaseViewModel
import com.alkesh.scoreboard.presentation.screens.splash.constant.SplashConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor() :
    BaseViewModel() {
    val navigateToDashboard = MutableLiveData<Boolean>()

    init {
        splashDelayed()
    }

    private fun splashDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToDashboard.value = true
        }, SplashConstant.splashDuration)
    }

}