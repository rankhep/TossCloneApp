package com.example.toss

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.toss.fragment.CreateFragment
import com.example.toss.fragment.MainFragment
import com.example.toss.fragment.MenuFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var tabNameStr = "홈"

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(
            context: Context,
            intent: Intent
        ) {
            val b = intent.getBooleanExtra("message", false)
            topShadow.visibility = if (b) View.VISIBLE else View.INVISIBLE
            tabName.visibility = if (b) View.VISIBLE else View.INVISIBLE
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(
            R.id.fragment, MainFragment()
        )
        fragmentTransaction.commit()

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver, IntentFilter("custom-event-name"))

        createBtn.setOnClickListener {
            setBottomBar()
            val f =fm.beginTransaction()
            f.replace(R.id.fragment, CreateFragment.newInstance())
            f.commit()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                createText.setTextColor(applicationContext.getColor(R.color.colorPrimary))

            createIcon.imageTintList =
                applicationContext.resources.getColorStateList(R.color.colorPrimary)
            addBtn.visibility = View.INVISIBLE
            tabName.text = "개설"
        }

        homeBtn.setOnClickListener {
            val f = fm.beginTransaction()
            f.replace(R.id.fragment, MainFragment())
            f.commit()
            addBtn.visibility = View.VISIBLE
            setBottomBar()
            tabName.text = "홈"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                homeText.setTextColor(applicationContext.getColor(R.color.colorPrimary))
            homeIcon.imageTintList =
                applicationContext.resources.getColorStateList(R.color.colorPrimary)
        }

        menuBtn.setOnClickListener {
            setBottomBar()
            addBtn.visibility = View.INVISIBLE
            val f = fm.beginTransaction()
            f.replace(R.id.fragment, MenuFragment.newInstance())
            f.commit()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                menuText.setTextColor(applicationContext.getColor(R.color.colorPrimary))
            tabName.text = "전체"
            menuIcon.imageTintList =
                applicationContext.resources.getColorStateList(R.color.colorPrimary)
        }

        timelineBtn.setOnClickListener {
            setBottomBar()

            addBtn.visibility = View.VISIBLE
            tabName.text = "타임라인"
            dayOutLine.setBackgroundResource(R.drawable.bg_round_sqaure_blue)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                day.setTextColor(applicationContext.getColor(R.color.colorPrimary))
                timeLineText.setTextColor(applicationContext.getColor(R.color.colorPrimary))
            }
        }
    }


    private fun setBottomBar() {


        homeIcon.imageTintList = applicationContext.resources.getColorStateList(R.color.black)
        menuIcon.imageTintList = applicationContext.resources.getColorStateList(R.color.black)
        createIcon.imageTintList =
            applicationContext.resources.getColorStateList(R.color.black)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            line.setBackgroundColor(applicationContext.getColor(R.color.bottomBarBlack))
            day.setTextColor(applicationContext.getColor(R.color.bottomBarBlack))
            homeText.setTextColor(applicationContext.getColor(R.color.bottomBarBlack))
            timeLineText.setTextColor(applicationContext.getColor(R.color.bottomBarBlack))
            createText.setTextColor(applicationContext.getColor(R.color.bottomBarBlack))
            menuText.setTextColor(applicationContext.getColor(R.color.bottomBarBlack))
        }




        dayOutLine.setBackgroundResource(R.drawable.bg_round_square)
    }

}
