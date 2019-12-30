package com.example.toss.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.toss.BorrowActivity
import com.example.toss.CardActivity
import com.example.toss.R
import kotlinx.android.synthetic.main.fragment_credit_level.view.*

class CreditLevelFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_credit_level, container, false)
        v.run {
            cardBtn.setOnClickListener {
                startActivity(Intent(context, CardActivity::class.java))
            }

            borrowBtn.setOnClickListener {
                startActivity(Intent(context, BorrowActivity::class.java))
            }
        }
        return v
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            CreditLevelFragment().apply {

            }
    }
}