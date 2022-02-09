package com.example.devapp.domain.repository

import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.data.utils.Resource
import kotlinx.coroutines.flow.Flow


interface GifRepository {
    suspend fun getListOfMemes(type: String,page:Int, pageSize: Int): GifsResponse
}