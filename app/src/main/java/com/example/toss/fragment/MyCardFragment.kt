package com.example.toss.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toss.CardReportActivity
import com.example.toss.R
import com.example.toss.model.Card
import com.example.toss.model.CardReport
import kotlinx.android.synthetic.main.fragment_my_card.view.*


class MyCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_my_card, container, false)
        v.run {
            ollehCard.setOnClickListener {
                val card = Card("Olleh KB 국민카드", "0원", "944542******6010", R.drawable.olleh_card)
                val array = ArrayList<CardReport>()
                val intent = Intent(context, CardReportActivity::class.java)
                intent.putExtra("reports", array)
                intent.putExtra("card", card)
                startActivity(intent)
            }
            chungCard.setOnClickListener {
                val card = Card("청춘대로 톡톡카드", "55,400원", "356415******9074", R.drawable.chung_card)
                val intent = Intent(context, CardReportActivity::class.java)
                val array = ArrayList<CardReport>()
                array.run {
                    add(CardReport("18 | 수", "모바일티머니충전(후불형)", "00:48 | 일시불", "2,900 원"))
                    add(CardReport("9 | 월", "LGUPLUS통신사요금자동이체", "13:05 | 일시불", "37,400 원"))
                    add(CardReport("5 | 목", "모바일티머니충전(후불형)", "00:38 | 일시불", "3,100 원"))
                    add(CardReport("4 | 수", "모바일티머니충전(후불형)", "00:47 | 일시불", "6,200 원"))
                    add(CardReport("3 | 화", "모바일티머니충전(후불형)", "01:38 | 일시불", "4,150 원"))
                    add(CardReport("2 | 월", "모바일티머니충전(후불형)", "09:34 | 일시불", "1,650 원"))
                }
                intent.putExtra("reports", array)
                intent.putExtra("card", card)
                startActivity(intent)
            }
        }

        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MyCardFragment().apply {

            }
    }
}
