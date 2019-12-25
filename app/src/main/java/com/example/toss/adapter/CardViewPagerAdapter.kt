package com.example.toss.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.toss.fragment.CardRecommndFragment
import com.example.toss.fragment.MyCardFragment
import com.example.toss.fragment.RecommendFragment

class CardViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return MyCardFragment.newInstance()
            }
            1 -> {
                return CardRecommndFragment.newInstance()
            }
        }
        return RecommendFragment.newInstance()
    }

    override fun getCount(): Int = 2

}