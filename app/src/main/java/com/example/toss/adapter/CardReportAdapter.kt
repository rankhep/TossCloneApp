package com.example.toss.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toss.R
import com.example.toss.model.CardReport
import kotlinx.android.synthetic.main.item_card_report.view.*

class CardReportAdapter(var items: ArrayList<CardReport>) :
    RecyclerView.Adapter<CardReportAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_report,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.run {
            date.text = items[position].day
            recordText.text = items[position].title
            timeText.text = items[position].time
            money.text = items[position].fee
        }
    }


}