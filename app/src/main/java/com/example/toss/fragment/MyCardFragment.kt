package com.example.toss.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toss.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_card, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MyCardFragment().apply {

            }
    }
}
