package com.example.toss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toss.adapter.BorrowViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_borrow_credit.*

class BorrowActivity : AppCompatActivity() {

    private lateinit var mAdapter: BorrowViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow_credit)
        mAdapter = BorrowViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mAdapter

        tab.addTab(tab.newTab().setText("내 대출 현황"))
        tab.addTab(tab.newTab().setText("대출 맞춤 추천"))

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
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tab))
        backBtn.setOnClickListener {
            finish()
        }

    }

}
