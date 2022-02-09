package com.example.devapp.data.repository

import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.data.remote.API
import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.repository.GifRepository
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@BoundTo(supertype = GifRepository::class, component = SingletonComponent::class)
class GifRepositoryImpl @Inject constructor(
    private val api: API,
) : GifRepository {
    override suspend fun getListOfMemes(type: String, page: Int, pageSize:Int): GifsResponse {
       return api.getListOfMemes(type,page,pageSize)
    }
}