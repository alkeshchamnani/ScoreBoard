package com.alkesh.scoreboard.presentation.screens.splash.activity

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.base.activity.AppBaseActivity
import com.alkesh.scoreboard.databinding.ActivitySplashBinding
import com.alkesh.scoreboard.presentation.screens.dashboard.activity.DashboardActivity
import com.alkesh.scoreboard.presentation.screens.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppBaseActivity<ActivitySplashBinding>() {
    private val viewModel: SplashViewModel by viewModels()
    override fun init() {

    }

    override fun setEvents() {
    }

    override fun setObservers() {
        viewModel.navigateToDashboard.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_splash
    override fun dataBinding(dataBinder: ActivitySplashBinding) {
        
    }
}