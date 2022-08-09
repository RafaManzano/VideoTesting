package es.rafamanzano.rickandmorty.data.source.remote

import es.rafamanzano.rickandmorty.data.source.remote.dto.CharacterDTO
import es.rafamanzano.rickandmorty.data.source.remote.dto.CharactersDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersDTO

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterDTO
}