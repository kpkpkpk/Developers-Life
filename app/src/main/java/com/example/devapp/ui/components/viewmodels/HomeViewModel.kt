package com.example.devapp.ui.components.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.example.devapp.domain.usecases.GetListOfMemesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListOfMemesUseCase: GetListOfMemesUseCase,
) {
    val s = flow<Int> {
        var a = 0
        emit(a)
        for (i in 0..10) {
            a++
            emit(a)
        }
    }
}