package com.rafamanzano.movietrailerstv.data.server

import com.rafamanzano.movietrailerstv.domain.Movie

data class Result(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun Result.toDomainMovie() = Movie(
    title,
    release_date,
    overview,
    "https://image.tmdb.org/t/p/w185/$poster_path",
    backdrop_path?.let { "https://image.tmdb.org/t/p/w780/$it" } ?: ""
)