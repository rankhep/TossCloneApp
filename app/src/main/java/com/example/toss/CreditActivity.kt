package com.example.toss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toss.adapter.CreditViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_borrow_credit.*

class CreditActivity :AppCompatActivity (){
    private lateinit var mAdapter: CreditViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow_credit)


        mAdapter = CreditViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mAdapter

        tab.addTab(tab.newTab().setText("내 카드 현황"))
        tab.addTab(tab.newTab().setText("카드 혜택추천"))

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                p0?.run {
                    viewPager.currentItem = position
                }
            }

        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        backBtn.setOnClickListener {
            finish()
        }
    }
}