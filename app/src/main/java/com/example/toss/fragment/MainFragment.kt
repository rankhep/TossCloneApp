package com.example.toss.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.toss.*
import com.example.toss.model.Card
import com.example.toss.model.CardReport
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false)
        view.run {
            swipeLayout.setOnRefreshListener {
                swipeLayout.isRefreshing = false
            }

            scrollView.viewTreeObserver
                .addOnScrollChangedListener {
                    val scrollY: Int = scrollView.scrollY // For ScrollView
                    Log.e("asd", "" + scrollY)
                    if (scrollY > 0) {
                        val intent = Intent("custom-event-name")
                        intent.putExtra("message", true)
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
                    } else {

                        val intent = Intent("custom-event-name")
                        intent.putExtra("message", false)
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
                    }
                }

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

            sendMoneyCard.setOnClickListener {
                Toast.makeText(context, "점검중입니다.", Toast.LENGTH_SHORT).show()
            }
            borrowCard.setOnClickListener {
                startActivity(Intent(context, BorrowActivity::class.java))
            }

            accountCard.setOnClickListener {
                startActivity(Intent(context, AccountActivity::class.java))
            }

            cardCard.setOnClickListener {
                startActivity(Intent(context, CardActivity::class.java))
            }

            creditLevelBtn.setOnClickListener {
                startActivity(Intent(context, CreditActivity::class.java))
            }

        }
        return view
    }
}