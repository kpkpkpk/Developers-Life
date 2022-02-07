package com.example.devapp.domain.model

import com.example.devapp.domain.model.response.GifResponse
import com.google.gson.annotations.SerializedName

data class GifsResponse(
   @SerializedName("result") val result: List<GifResponse>?,
   @SerializedName("totalCount") val totalCount:Int?
)
