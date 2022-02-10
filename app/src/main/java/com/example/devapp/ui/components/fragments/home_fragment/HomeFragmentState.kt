package com.example.devapp.ui.components.fragments.home_fragment

import androidx.paging.PagingData
import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.model.GifsResponse

data class HomeFragmentState(
    val isLoading: Boolean = false,
    val memes:PagingData<GifModel> = PagingData.empty(),
    val error: String = ""
)