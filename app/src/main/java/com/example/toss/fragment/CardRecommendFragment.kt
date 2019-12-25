package com.example.toss.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toss.R

class CardRecommndFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_card_recommend, container, false)
        return v
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            CardRecommndFragment().apply {

            }
    }
}
