package com.example.devapp.domain.repository

import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.model.GifsResponse
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo

interface GifRepository {
    suspend fun getGifsResponse(type:String,page:Int,pageSize:Int): Resource<GifsResponse>
}