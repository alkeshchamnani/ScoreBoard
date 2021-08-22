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
import com.alkesh.scoreboard.presentation.screens.score.constant.ResultDetailConstant
import com.alkesh.scoreboard.presentation.screens.score.viewModel.ResultDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.cell_list_game_result.*
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
        if (ob is UIGameResultModel) {
            viewModel.setResults(ob)
        }
    }

    private fun populateGameResult(uiGameResultModel: UIGameResultModel) {
        uiGameResultModel.score?.let {
            val arrayScore = it.split("-")
            tvTeamAScore.text = arrayScore[0]
            tvTeamBScore.text = arrayScore[1]
        }
        uiGameResultModel.teamA?.let {
            tvTeamAName.text = NameUtil.getShortName(it)
        }
        uiGameResultModel.teamB?.let {
            tvTeamBName.text = NameUtil.getShortName(it)
        }
        uiGameResultModel.linkA?.let {
           // ImageUtil.loadImage(ivTeamAFlag, it)
        }
        uiGameResultModel.linkB?.let {
           // ImageUtil.loadImage(ivTeamBFlag, it)
        }
        uiGameResultModel.date?.let {
            try {
                val calendar = DateAndTimeUtil.getCalendar(it, DateFormats.Server_Date_Format)
                val date = DateAndTimeUtil.formatCalender(calendar, DateFormats.UIDateFormat)
                val time = DateAndTimeUtil.formatCalender(calendar, DateFormats.UITimeFormat)
                tvDate.text = date
                tvTime.text = time
            } catch (exp: Exception) {
                tvDate.text = "N/A"
                tvTime.text = "N/A"
            }
        }
    }
}