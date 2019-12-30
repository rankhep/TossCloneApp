package com.example.toss.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.toss.fragment.LoadingFragment
import com.example.toss.fragment.ReportFragment

class TimeLineViewPagerAdapter(var fragmentManager:FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position){
            1-> return ReportFragment.newInstance()
        }
        return LoadingFragment.newInstance()
    }

    override fun getCount(): Int = 3

}