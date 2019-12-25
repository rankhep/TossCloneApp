package com.example.toss.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.toss.fragment.CardRecommndFragment
import com.example.toss.fragment.CreditLevelFragment
import com.example.toss.fragment.MyBorrowFragment
import com.example.toss.fragment.RecommendFragment

class CreditViewPagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CreditLevelFragment.newInstance()
            }
            1 -> {
                return RecommendFragment()
            }

            2->{
                return CardRecommndFragment.newInstance()
            }

        }
        return CreditLevelFragment.newInstance()
    }

    override fun getCount(): Int = 3
}