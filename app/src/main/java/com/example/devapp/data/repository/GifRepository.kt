package com.example.devapp.data.repository

import com.example.devapp.data.model.GifsResponse
import com.example.devapp.data.utils.Resource
import kotlinx.coroutines.flow.Flow


interface GifRepository {
    fun getListOfMemes(type: String, page: Int): Flow<Resource<GifsResponse>>
}