package com.example.devapp.ui.components.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.usecases.GetListOfMemesUseCase
import com.example.devapp.ui.components.fragments.home_fragment.HomeFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListOfMemesUseCase: GetListOfMemesUseCase,
) : ViewModel() {
    private val _type = MutableStateFlow("")
    private val _memes: StateFlow<PagingData<GifModel>> = _type
        .map(::newPager)
        .flatMapLatest { pager ->
            pager.flow
        }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    val memes: StateFlow<PagingData<GifModel>>
        get() = _memes
    private var newPagingSource: PagingSource<*, *>? = null
    private fun newPager(type: String): Pager<Int, GifModel> {
        return Pager(PagingConfig(5, enablePlaceholders = false)) {
            getListOfMemesUseCase(type).also { newPagingSource = it }
        }
    }

    fun setType(type: String) {
        _type.tryEmit(type)
    }

//    fun getListOfMemes(type: String) {
////        getListOfMemesUseCase(type).onEach { result ->
////            Log.d("checkVM", "getListOfMemes: ")
////            when (result) {
////                is Resource.Success -> {
////                    _state.emit(HomeFragmentState(memesList = responseToGifModelArray(result.data!!)))
////                }
////                is Resource.Loading -> {
////                    _state.emit(HomeFragmentState(isLoading = true))
////                }
////                is Resource.Error -> {
////                    _state.emit(HomeFragmentState(error = result.message ?: "Unexpected error"))
////                }
////            }
////        }.launchIn(viewModelScope)
//    }

}