package com.rafamanzano.movietrailerstv.ui.common

import androidx.annotation.StringRes
import com.rafamanzano.movietrailerstv.R

enum class Options(@StringRes val stringRes: Int) {
    WATCH_TRAILER(R.string.watch_later),
    FAVORITE(R.string.favorite)
}