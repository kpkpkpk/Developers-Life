package com.example.devapp.domain.repository

import androidx.paging.PagingSource
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.model.GifModel
import kotlinx.coroutines.flow.Flow


interface GifRepository {
    fun getMemes(type:String): PagingSource<Int,GifModel>
}