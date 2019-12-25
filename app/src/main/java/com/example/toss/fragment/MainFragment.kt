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
import com.example.toss.AccountActivity
import com.example.toss.BorrowActivity
import com.example.toss.CardActivity
import com.example.toss.R
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
        }
        return view
    }
}