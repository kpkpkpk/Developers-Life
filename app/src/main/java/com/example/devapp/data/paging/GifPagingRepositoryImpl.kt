package com.example.devapp.data.paging

import androidx.paging.PagingSource
import com.example.devapp.domain.model.GifModel
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import javax.inject.Inject

@BoundTo(supertype = GifPagingRepository::class, component = SingletonComponent::class)
class GifPagingRepositoryImpl @Inject constructor(
    private val memesPageSourceFactory: MemesPageSource.Factory,
) : GifPagingRepository {
    override fun getMemes(type: String): PagingSource<Int,GifModel> {
       return memesPageSourceFactory.create(type)
    }
}