package es.rafamanzano.rickandmorty.domain.usecase

import es.rafamanzano.rickandmorty.data.Result
import es.rafamanzano.rickandmorty.domain.model.Characters
import es.rafamanzano.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }
}