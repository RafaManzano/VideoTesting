package com.rafamanzano.movietrailerstv.data

import com.rafamanzano.movietrailerstv.data.server.RemoteConnection
import com.rafamanzano.movietrailerstv.data.server.toDomainMovie
import com.rafamanzano.movietrailerstv.domain.Category
import com.rafamanzano.movietrailerstv.domain.Movie

class MovieRepository(private val apiKey: String) {
    suspend fun getCategories(): Map<Category, List<Movie>> {
        return Category.values().associateWith { category ->
            RemoteConnection
                .service
                .listPopularMovies(apiKey, category.id)
                .results.map { it.toDomainMovie() }
        }
    }
}