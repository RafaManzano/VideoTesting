package es.rafamanzano.rickandmorty.domain.usecase

import es.rafamanzano.rickandmorty.data.Result
import es.rafamanzano.rickandmorty.domain.model.Character
import es.rafamanzano.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}