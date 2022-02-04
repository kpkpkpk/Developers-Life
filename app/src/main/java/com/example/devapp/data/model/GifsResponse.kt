package com.example.devapp.data.model

import com.example.devapp.data.model.response.GifResponse
import com.google.gson.annotations.SerializedName

data class GifsResponse(
   @SerializedName("result") val result: List<GifResponse>?,
   @SerializedName("totalCount") val totalCount:Int?
)
