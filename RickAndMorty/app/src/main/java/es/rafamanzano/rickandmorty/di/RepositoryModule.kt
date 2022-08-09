package es.rafamanzano.rickandmorty.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import es.rafamanzano.rickandmorty.data.repository.CharacterRepositoryImpl
import es.rafamanzano.rickandmorty.domain.repository.CharacterRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}