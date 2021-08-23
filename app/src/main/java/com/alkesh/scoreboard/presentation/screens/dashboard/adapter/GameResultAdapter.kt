package com.alkesh.scoreboard.presentation.screens.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.common.util.DateAndTimeUtil
import com.alkesh.scoreboard.common.util.DateFormats
import com.alkesh.scoreboard.common.util.ImageUtil
import com.alkesh.scoreboard.common.util.NameUtil
import com.alkesh.scoreboard.databinding.CellListGameResultBinding
import com.alkesh.scoreboard.presentation.screens.dashboard.listener.OnResultSelected
import kotlinx.android.synthetic.main.cell_list_game_result.view.*


class GameResultAdapter(
    private val context: Context,
    private val list: ArrayList<UIGameResultModel>,
    private val onResultSelected: OnResultSelected
) : RecyclerView.Adapter<GameResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CellListGameResultBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cell_list_game_result, parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.bind(model, holder.itemView)
        holder.itemView.setOnClickListener(View.OnClickListener {
            onResultSelected.onClicked(model)
        })
    }

    class ViewHolder(private val cellListGameResultBinding: CellListGameResultBinding) :
        RecyclerView.ViewHolder(cellListGameResultBinding.getRoot()) {


        fun bind(model: UIGameResultModel, view: View) {
            model.score?.let {
                val arrayScore = it.split("-")
                cellListGameResultBinding.teamAScore = arrayScore[0]
                cellListGameResultBinding.teamBScore = arrayScore[1]
            }
            model.teamA?.let {
                cellListGameResultBinding.teamAName = NameUtil.getShortName(it)
            }
            model.teamB?.let {
                cellListGameResultBinding.teamBName = NameUtil.getShortName(it)
            }
            model.linkA?.let {
                ImageUtil.loadImage(view.ivTeamAFlag.context, view.ivTeamAFlag, it)
            }
            model.linkB?.let {
                ImageUtil.loadImage(view.ivTeamAFlag.context, view.ivTeamBFlag, it)
            }
            model.date?.let {
                try {
                    val calendar = DateAndTimeUtil.getCalendar(it, DateFormats.Server_Date_Format)
                    val date = DateAndTimeUtil.formatCalender(calendar, DateFormats.UIDateFormat)
                    val time = DateAndTimeUtil.formatCalender(calendar, DateFormats.UITimeFormat)
                    cellListGameResultBinding.resultDate = date
                    cellListGameResultBinding.resultTime = time
                } catch (exp: Exception) {
                    cellListGameResultBinding.resultDate = "N/A"
                    cellListGameResultBinding.resultTime = "N/A"
                }
            }
        }
    }


}