package com.rafamanzano.movietrailerstv.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.rafamanzano.movietrailerstv.R


class MainActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}