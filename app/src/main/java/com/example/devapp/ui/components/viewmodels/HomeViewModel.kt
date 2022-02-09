package com.example.devapp.ui.components.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.domain.usecases.GetListOfMemesUseCase
import com.example.devapp.ui.components.fragments.home_fragment.HomeFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListOfMemesUseCase: GetListOfMemesUseCase,
) : ViewModel() {
    private val _state =
        MutableStateFlow<HomeFragmentState>(HomeFragmentState())
    val state: StateFlow<HomeFragmentState>
        get() = _state

    fun getListOfMemes(type: String, page: Int) {
        getListOfMemesUseCase(type, page).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.emit(HomeFragmentState(memesList = responseToGifModelArray(result.data!!)))
                }
                is Resource.Loading -> {
                    _state.emit(HomeFragmentState(isLoading = true))
                }
                is Resource.Error -> {
                    _state.emit(HomeFragmentState(error = result.message ?: "Unexpected error"))
                }
            }
        }
    }

    private fun responseToGifModelArray(data: GifsResponse): List<GifModel> {
        val arrayList: ArrayList<GifModel> = ArrayList()
        for (value in data.result!!) {
            arrayList.add(value.toGifModel())
        }
        return arrayList
    }
}