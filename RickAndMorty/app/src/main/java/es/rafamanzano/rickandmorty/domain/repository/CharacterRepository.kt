package es.rafamanzano.rickandmorty.domain.repository

import es.rafamanzano.rickandmorty.data.Result
import es.rafamanzano.rickandmorty.domain.model.Character
import es.rafamanzano.rickandmorty.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(page: Int): Flow<Result<List<Characters>>>
    suspend fun getCharacter(id: Int): Result<Character>
}