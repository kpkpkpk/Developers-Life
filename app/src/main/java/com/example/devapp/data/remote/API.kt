package com.example.devapp.data.remote

import com.example.devapp.data.model.GifsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("/{type}/{page}?json=true")
    suspend fun getListOfMemes(
        @Path("type", encoded = true) type: String,
        @Path("page", encoded = true) page: String
    ): GifsResponse
}