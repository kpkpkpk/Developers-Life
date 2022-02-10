package com.example.devapp.data.paging

import androidx.paging.PagingSource
import com.example.devapp.domain.model.GifModel
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo


interface GifPagingRepository {
    fun getMemes(type:String): PagingSource<Int,GifModel>
}