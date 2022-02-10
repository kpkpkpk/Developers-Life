package com.example.devapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.devapp.data.local.Constants
import com.example.devapp.data.utils.toGifModel
import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.domain.usecases.GetListOfMemesUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MemesPageSource @AssistedInject constructor(
    private val api: API,
    @Assisted("type") private val type: String,
) : PagingSource<Int, GifModel>() {
    override fun getRefreshKey(state: PagingState<Int, GifModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GifModel> {
        //Если у нас нет категории мемов, то мы не можем ничего вывести
        if (type.isEmpty()) {
            return LoadResult.Page(emptyList(), null, null)
        }
        // Создаем запросы для нашего api
        val pageNumber = params.key ?: 0
        // Ограничиваем максимальное количество постов с апишки до 10
        val pageSize = params.loadSize.coerceAtMost(Constants.MAX_PAGE_SIZE)
        //Делаем запрос к серверу
        try {
            val response = api.getListOfMemes(type, pageNumber, pageSize)
            return if (response.isSuccessful) {
                val listOfGifModels = response.body()!!.result.map { it.toGifModel() }
                val nextPageNumber = if (listOfGifModels.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 0) pageNumber - 1 else null
                LoadResult.Page(listOfGifModels,
                    prevKey = prevPageNumber,
                    nextKey = nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }


    }


    @AssistedFactory
    interface Factory {
        fun create(@Assisted("type") type: String): MemesPageSource
    }
}