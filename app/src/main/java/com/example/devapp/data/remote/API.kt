package com.example.devapp.data.remote

import androidx.annotation.IntRange
import com.example.devapp.domain.model.GifsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("/{type}/{page}?json=true")
    suspend fun getListOfMemes(
        @Path("type", encoded = true) type: String,
        @Path("page", encoded = true) page: Int,
        @Query("pageSize", encoded = true) pageSize: Int
    ): GifsResponse
}