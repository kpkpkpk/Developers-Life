package com.example.devapp.data.repository

import com.example.devapp.data.model.GifsResponse
import com.example.devapp.data.remote.API
import com.example.devapp.data.utils.Resource
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@BoundTo(supertype = GifRepository::class, component = SingletonComponent::class)
class GifRepositoryImpl @Inject constructor(
    private val api: API,
) : GifRepository {
    override fun getListOfMemes(type: String, page: Int): Flow<Resource<GifsResponse>> {
      TODO()
    }
}