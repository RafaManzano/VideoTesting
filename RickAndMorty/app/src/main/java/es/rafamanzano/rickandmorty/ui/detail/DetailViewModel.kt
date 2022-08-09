package es.rafamanzano.rickandmorty.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.rafamanzano.rickandmorty.data.Result
import es.rafamanzano.rickandmorty.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    init {
        getCharacter()
    }

    var state by mutableStateOf(DetailState())
        private set


    private fun getCharacter() {
        savedStateHandle.get<Int>("id")?.let { characterID ->
            viewModelScope.launch {
                getCharacterUseCase(characterID).also { result ->
                    when (result) {

                        is Result.Success -> {
                            state = state.copy(
                                character = result.data,
                                isLoading = false
                            )
                        }

                        is Result.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }

                        is Result.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }

}
