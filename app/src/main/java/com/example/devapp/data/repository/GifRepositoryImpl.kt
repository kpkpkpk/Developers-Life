package com.example.devapp.data.repository

import androidx.paging.PagingSource
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.data.remote.API
import com.example.devapp.data.remote.MemesPageSource
import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.repository.GifRepository
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@BoundTo(supertype = GifRepository::class, component = SingletonComponent::class)
class GifRepositoryImpl @Inject constructor(
    private val memesPageSourceFactory: MemesPageSource.Factory,
) : GifRepository {
    override fun getMemes(type: String): PagingSource<Int,GifModel> {
       return memesPageSourceFactory.create(type)
    }
}