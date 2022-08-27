package com.rafamanzano.movietrailerstv.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.rafamanzano.movietrailerstv.R

class DetailActivity : FragmentActivity() {

    companion object {
        const val MOVIE_EXTRA = "extra:movie"
        const val SHARED_ELEMENT_NAME = "extra:image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}