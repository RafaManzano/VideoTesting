package es.rafamanzano.rickandmorty.ui.home

import es.rafamanzano.rickandmorty.domain.model.Characters

data class HomeState(
    val characters: List<Characters> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)
