package com.example.toss.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.toss.R
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_menu, container, false)
        v.run {
            scroll_view.viewTreeObserver
                .addOnScrollChangedListener {
                    val scrollY: Int = scroll_view.scrollY
                    if (scrollY > 0) {
                        val intent = Intent("custom-event-name")
                        intent.putExtra("message", true)
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
                    } else {

                        val intent = Intent("custom-event-name")
                        intent.putExtra("message", false)
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
                    }
                }
        }
        return v
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            MenuFragment().apply {

            }
    }
}