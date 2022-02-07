package com.example.devapp.domain.usecases

import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.domain.repository.GifRepository
import com.example.devapp.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListOfMemesUseCase @Inject constructor(
    private val gifRepository: GifRepository
) {
    operator fun invoke(type:String, page:Int): Flow<Resource<GifsResponse>> = flow{
       try {
           emit(Resource.Loading<GifsResponse>())
           emit(Resource.Success<GifsResponse>(data = gifRepository.getListOfMemes(type,page)))

       } catch(e: HttpException) {
           emit(Resource.Error<GifsResponse>(e.localizedMessage ?: "An unexpected error occured"))
       } catch(e: IOException) {
           emit(Resource.Error<GifsResponse>("Couldn't reach server. Check your internet connection."))
       }
       }

}