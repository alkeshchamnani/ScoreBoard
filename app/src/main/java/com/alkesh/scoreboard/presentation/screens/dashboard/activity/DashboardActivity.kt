package com.alkesh.scoreboard.presentation.screens.dashboard.activity

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.base.activity.AppBaseActivity
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.presentation.screens.dashboard.adapter.GameResultAdapter
import com.alkesh.scoreboard.presentation.screens.dashboard.listener.OnResultSelected
import com.alkesh.scoreboard.presentation.screens.dashboard.viewModel.DashboardViewModel
import com.alkesh.scoreboard.presentation.screens.score.activity.ResultDetailActivity
import com.alkesh.scoreboard.presentation.screens.score.constant.ResultDetailConstant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class DashboardActivity : AppBaseActivity() {
    private val viewModel: DashboardViewModel by viewModels()
    override fun init() {
        toolbar.setup(this, getString(R.string.activity_dashboard_title), false)

    }

    override fun setEvents() {
        swipeRefresh.setOnRefreshListener {
            viewModel.getData()
        }
    }

    override fun setObservers() {
        viewModel.listResults.observe(this, Observer {
            if (it.isNotEmpty()) {
                populateList(it)
            }

        })
        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    //showLoadingDialog()
                    progressBar.visibility = View.VISIBLE
                    swipeRefresh.isRefreshing = true
                } else {
                    //hideLoadingDialog()
                    progressBar.visibility = View.GONE
                    swipeRefresh.isRefreshing = false
                }
            }
        })
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_dashboard
    }

    private fun populateList(list: ArrayList<UIGameResultModel>) {
        val adapter = GameResultAdapter(this, list, onResultSelected)
        bindVerticalAdapterWithRecyclerview(recyclerView, adapter)
    }

    private val onResultSelected = object : OnResultSelected {
        override fun onClicked(uiGameResultModel: UIGameResultModel) {
            val intent = Intent(this@DashboardActivity, ResultDetailActivity::class.java)
            intent.putExtra(ResultDetailConstant.Bundle_Result_Model, uiGameResultModel)
            startAnotherActivity(intent)
        }
    }
}