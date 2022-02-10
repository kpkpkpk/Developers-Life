package com.example.devapp.data.repository

import androidx.paging.PagingSource
import com.example.devapp.data.paging.GifPagingRepository
import com.example.devapp.data.remote.API
import com.example.devapp.data.utils.Resource
import com.example.devapp.data.utils.toGifModel
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.domain.repository.GifRepository
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
@BoundTo(supertype = GifRepository::class, component = SingletonComponent::class)
class GifRepositoryImpl @Inject constructor(
    private val api: API,
) : GifRepository {
    override suspend fun getGifsResponse(
        type: String,
        page: Int,
        pageSize: Int,
    ): Resource<GifsResponse> {
        return try {
            val response = api.getListOfMemes(type, page, pageSize)
            if (response.isSuccessful) {
                Resource.Success<GifsResponse>(data = response.body()!!)
            } else {
                Resource.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            Resource.Error(e)
        } catch (e: IOException) {
            Resource.Error(e)
        }
    }
}