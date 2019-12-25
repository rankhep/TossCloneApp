package com.example.toss.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.toss.fragment.MyBorrowFragment
import com.example.toss.fragment.RecommendFragment

class BorrowViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return MyBorrowFragment.newInstance()
            }
            1 -> {
                return RecommendFragment()
            }
        }
        return RecommendFragment.newInstance()
    }

    override fun getCount(): Int = 2

}