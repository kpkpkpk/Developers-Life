package com.example.devapp.data.remote

import com.example.devapp.domain.model.GifsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("/{type}/{page}?json=true")
    suspend fun getListOfMemes(
        @Path("type", encoded = true) type: String,
        @Path("page", encoded = true) page: Int
    ): GifsResponse
}