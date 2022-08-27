package com.rafamanzano.movietrailerstv.ui.detail

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import com.rafamanzano.movietrailerstv.domain.Movie

class DetailsDescriptionPresenter: AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder, item: Any) {
        val movie = item as Movie
        vh.title.text = movie.title
        vh.subtitle.text = movie.releaseDate
        vh.body.text = movie.summary
    }
}
