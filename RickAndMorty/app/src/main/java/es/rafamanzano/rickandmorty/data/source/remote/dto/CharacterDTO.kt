package es.rafamanzano.rickandmorty.data.source.remote.dto

import es.rafamanzano.rickandmorty.domain.model.Character

data class CharacterDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDTO.toCharacter(): Character {
    return Character(
        this.id,
        this.name,
        this.status,
        this.species,
        this.gender,
        this.origin,
        this.location,
        this.image
    )
}