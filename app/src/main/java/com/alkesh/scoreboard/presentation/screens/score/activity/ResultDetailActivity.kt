package com.alkesh.scoreboard.presentation.screens.score.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.base.activity.AppBaseActivity
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.common.util.DateAndTimeUtil
import com.alkesh.scoreboard.common.util.DateFormats
import com.alkesh.scoreboard.common.util.ImageUtil
import com.alkesh.scoreboard.common.util.NameUtil
import com.alkesh.scoreboard.databinding.ActivityResultDetailBinding
import com.alkesh.scoreboard.presentation.screens.score.constant.ResultDetailConstant
import com.alkesh.scoreboard.presentation.screens.score.viewModel.ResultDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.cell_list_game_result.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class ResultDetailActivity : AppBaseActivity<ActivityResultDetailBinding>() {
    private val viewModel: ResultDetailViewModel by viewModels()
    private lateinit var dataBinding: ActivityResultDetailBinding
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
        if (ob is UIGameResultModel) {
            viewModel.setResults(ob)
        }
    }

    private fun populateGameResult(uiGameResultModel: UIGameResultModel) {

        uiGameResultModel.score?.let {
            val arrayScore = it.split("-")
            dataBinding.teamAScore = arrayScore[0]
            dataBinding.teamBScore = arrayScore[1]
        }
        uiGameResultModel.teamA?.let {
            dataBinding.teamAName = NameUtil.getShortName(it)
        }
        uiGameResultModel.teamB?.let {
            dataBinding.teamBName = NameUtil.getShortName(it)
        }
        uiGameResultModel.linkA?.let {
            ImageUtil.loadImage(ivTeamAFlag.context, ivTeamAFlag, it)
        }
        uiGameResultModel.linkB?.let {
            ImageUtil.loadImage(ivTeamAFlag.context, ivTeamBFlag, it)
        }
        uiGameResultModel.date?.let {
            try {
                val calendar = DateAndTimeUtil.getCalendar(it, DateFormats.Server_Date_Format)
                val date = DateAndTimeUtil.formatCalender(calendar, DateFormats.UIDateFormat)
                val time = DateAndTimeUtil.formatCalender(calendar, DateFormats.UITimeFormat)
                dataBinding.resultDate = date
                dataBinding.resultTime = time

            } catch (exp: Exception) {
                dataBinding.resultDate = "N/A"
                dataBinding.resultTime = "N/A"
            }
        }
    }

    override fun dataBinding(binder: ActivityResultDetailBinding) {
        dataBinding = binder
    }
}