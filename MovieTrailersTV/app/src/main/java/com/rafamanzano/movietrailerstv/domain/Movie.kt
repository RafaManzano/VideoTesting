package com.rafamanzano.movietrailerstv.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val releaseDate: String,
    val summary: String,
    val poster: String,
    val backDrop: String
): Parcelable