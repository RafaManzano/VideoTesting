package com.rafamanzano.movietrailerstv.ui.detail

import android.app.Activity
import android.widget.Toast
import androidx.leanback.widget.Action
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper
import com.rafamanzano.movietrailerstv.ui.common.Options

class FullWidthDetailsMovieRowPresenter(private val activity: Activity) : FullWidthDetailsOverviewRowPresenter(DetailsDescriptionPresenter()) {

    init {
        val sharedElementHelper = FullWidthDetailsOverviewSharedElementHelper()
        sharedElementHelper.setSharedElementEnterTransition(
            activity, DetailActivity.SHARED_ELEMENT_NAME
        )
        setListener(sharedElementHelper)
        isParticipatingEntranceTransition = true
    }

    fun buildActions(): ArrayObjectAdapter {

        setOnActionClickedListener { action ->
            val option = Options.values().first { it.ordinal == action.id.toInt() }
            Toast.makeText(activity, option.stringRes, Toast.LENGTH_SHORT).show()
        }

        return ArrayObjectAdapter().apply {
            Options.values().forEach { option ->
                add(Action(option.ordinal.toLong(), activity.getString(option.stringRes)))
            }
        }
    }
}