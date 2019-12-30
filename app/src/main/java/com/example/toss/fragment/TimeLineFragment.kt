package com.example.toss.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.toss.R
import com.example.toss.adapter.TimeLineViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_time_line.view.*

class TimeLineFragment() :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_time_line, container, false)
        v.run {
            pager.adapter = TimeLineViewPagerAdapter(fragmentManager!!)
            pager.setCurrentItem(1,false)
            tab.addTab(tab.newTab().setText("달력"))
            tab.addTab(tab.newTab().setText("거래 내역"))
            tab.addTab(tab.newTab().setText("소비리포트"))

            tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(p0: TabLayout.Tab?) {
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {
                }

                override fun onTabSelected(p0: TabLayout.Tab?) {
                    p0?.run {
                        pager.currentItem = position
                    }
                }

            })
            pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        }
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TimeLineFragment().apply {

            }
    }
}