package com.example.toss.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.toss.R

class CreateFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_create, container, false)
        return v
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            CreateFragment().apply {

            }
    }
}