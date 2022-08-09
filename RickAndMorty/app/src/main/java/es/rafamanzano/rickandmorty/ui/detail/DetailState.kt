package es.rafamanzano.rickandmorty.ui.detail

import es.rafamanzano.rickandmorty.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)
