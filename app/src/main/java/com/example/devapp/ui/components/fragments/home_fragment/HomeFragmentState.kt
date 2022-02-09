package com.example.devapp.ui.components.fragments.home_fragment

import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.model.GifsResponse

data class HomeFragmentState(
    val isLoading: Boolean = false,
    val memesList:List<GifModel> = emptyList(),
    val error: String = ""
)