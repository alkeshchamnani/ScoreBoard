package com.alkesh.scoreboard.presentation.screens.score.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.base.activity.AppBaseActivity
import com.alkesh.scoreboard.common.models.dto.GameResultModel
import com.alkesh.scoreboard.common.util.ImageUtil
import com.alkesh.scoreboard.presentation.screens.score.constant.ResultDetailConstant
import com.alkesh.scoreboard.presentation.screens.score.viewModel.ResultDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_result_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class ResultDetailActivity : AppBaseActivity() {
    private val viewModel: ResultDetailViewModel by viewModels()

    override fun init() {
        toolbar.setup(this, getString(R.string.activity_result_detail_title), true)
    }

    override fun setEvents() {

    }

    override fun setObservers() {
        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    showLoadingDialog()
                } else {
                    hideLoadingDialog()
                }
            }
        })
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })

        viewModel.gameResultModel.observe(this, Observer {
            it?.let {
                populateGameResult(it)
            }
        })
        viewModel.readDataFromBundle.observe(this, Observer {
            if (it) {
                readDataFromBundle()
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_result_detail

    private fun readDataFromBundle() {
        val ob = intent.getSerializableExtra(ResultDetailConstant.Bundle_Result_Model)
        if (ob is GameResultModel) {
            viewModel.setResults(ob)
        }
    }

    private fun populateGameResult(model: GameResultModel) {
        model.apply {
            tvDate.text = date ?: ""
            ivBanner?.let {
                ImageUtil.loadImage(ivBanner.context, ivBanner, linkA)
            }
        }
    }
}