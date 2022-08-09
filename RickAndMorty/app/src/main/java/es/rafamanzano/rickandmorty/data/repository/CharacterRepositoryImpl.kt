package es.rafamanzano.rickandmorty.data.repository

import es.rafamanzano.rickandmorty.data.Result
import es.rafamanzano.rickandmorty.data.source.remote.RickAndMortyApi
import es.rafamanzano.rickandmorty.data.source.remote.dto.toCharacter
import es.rafamanzano.rickandmorty.data.source.remote.dto.toListCharacters
import es.rafamanzano.rickandmorty.domain.model.Character
import es.rafamanzano.rickandmorty.domain.model.Characters
import es.rafamanzano.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "Oops, something went wrong",
                    data = null
                )
            )
        } catch (e: IOException) {
            emit(
                Result.Error(
                    message = "Couldn't reach server. check your internet connection",
                    data = null
                )
            )
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        return try {
            Result.Success(api.getCharacter(id).toCharacter())
        } catch (e: Exception) {
            Result.Error("An unknown error ocurred")
        }
    }
}