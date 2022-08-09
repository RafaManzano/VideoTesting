package es.rafamanzano.rickandmorty.data.source.remote.dto

import es.rafamanzano.rickandmorty.domain.model.Characters

data class CharactersDTO(
    val info: Info,
    val results: List<Result>
)

fun CharactersDTO.toListCharacters(): List<Characters> {
    val resultEntries = results.mapIndexed{_, entries ->
        Characters(
            entries.id,
            entries.name,
            entries.species,
            entries.image
        )
    }
    return resultEntries
}