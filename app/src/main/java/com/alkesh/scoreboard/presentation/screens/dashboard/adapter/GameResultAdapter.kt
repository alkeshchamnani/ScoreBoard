package com.alkesh.scoreboard.presentation.screens.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alkesh.scoreboard.R
import com.alkesh.scoreboard.common.uiModels.UIGameResultModel
import com.alkesh.scoreboard.common.util.DateAndTimeUtil
import com.alkesh.scoreboard.common.util.DateFormats
import com.alkesh.scoreboard.common.util.ImageUtil
import com.alkesh.scoreboard.common.util.NameUtil
import com.alkesh.scoreboard.presentation.screens.dashboard.listener.OnResultSelected
import kotlinx.android.synthetic.main.cell_list_game_result.view.*


class GameResultAdapter(
    private val context: Context,
    private val list: ArrayList<UIGameResultModel>,
    private val onResultSelected: OnResultSelected
) : RecyclerView.Adapter<GameResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_list_game_result, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        model.score?.let {
            val arrayScore = it.split("-")
            holder.tvTeamAScore.text = arrayScore[0]
            holder.tvTeamBScore.text = arrayScore[1]
        }
        model.teamA?.let {
            holder.tvTeamAName.text = NameUtil.getShortName(it)
        }
        model.teamB?.let {
            holder.tvTeamBName.text = NameUtil.getShortName(it)
        }
        model.linkA?.let {
            ImageUtil.loadImage(holder.ivTeamAFlag.context,holder.ivTeamAFlag, it)
        }
        model.linkB?.let {
            ImageUtil.loadImage(holder.ivTeamAFlag.context,holder.ivTeamBFlag, it)
        }
        model.date?.let {
            try {
                val calendar = DateAndTimeUtil.getCalendar(it, DateFormats.Server_Date_Format)
                val date = DateAndTimeUtil.formatCalender(calendar, DateFormats.UIDateFormat)
                val time = DateAndTimeUtil.formatCalender(calendar, DateFormats.UITimeFormat)
                holder.tvDate.text = date
                holder.tvTime.text = time
            } catch (exp: Exception) {
                holder.tvDate.text = "N/A"
                holder.tvTime.text = "N/A"
            }
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            onResultSelected.onClicked(model)
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTeamAScore: TextView = view.tvTeamAScore
        val tvTeamBScore: TextView = view.tvTeamBScore

        val tvTeamAName: TextView = view.tvTeamAName
        val tvTeamBName: TextView = view.tvTeamBName

        val ivTeamAFlag: ImageView = view.ivTeamAFlag
        val ivTeamBFlag: ImageView = view.ivTeamBFlag

        val tvDate: TextView = view.tvDate
        val tvTime: TextView = view.tvTime
    }


}