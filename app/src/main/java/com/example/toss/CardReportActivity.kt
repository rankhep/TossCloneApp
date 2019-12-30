package com.example.toss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.toss.adapter.CardReportAdapter
import com.example.toss.model.Card
import com.example.toss.model.CardReport
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_card_report.*
import kotlinx.android.synthetic.main.activity_card_report.backBtn

class CardReportActivity : AppCompatActivity() {
    var items = ArrayList<CardReport>()
    lateinit var mAdapter: CardReportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_report)

        items = intent.getSerializableExtra("reports") as ArrayList<CardReport>
        var card = intent.getSerializableExtra("card") as Card


        mAdapter = CardReportAdapter(items)
        list.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
        if (items.size == 0) {
            chungCard.visibility = View.GONE
            noRecord.visibility = View.VISIBLE
        }

        cardImg.setImageResource(card.src)
        account.text = card.account
        cardName.text = card.name
        money.text = card.money

        backBtn.setOnClickListener {
            finish()
        }
    }
}
