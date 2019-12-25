package com.example.toss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toss.adapter.CardViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_card.*

class CardActivity : AppCompatActivity() {
    private lateinit var mAdapter: CardViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        mAdapter = CardViewPagerAdapter(supportFragmentManager)
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
