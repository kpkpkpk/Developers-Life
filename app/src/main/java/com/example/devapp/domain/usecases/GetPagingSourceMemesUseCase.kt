package com.example.devapp.domain.usecases

import androidx.paging.PagingSource
import com.example.devapp.data.paging.GifPagingRepository
import com.example.devapp.domain.model.GifModel
import javax.inject.Inject

class GetPagingSourceMemesUseCase @Inject constructor(
    private val gifPagingRepository: GifPagingRepository
) {
//    operator fun invoke(type:String,page:Int,pageSize:Int): Flow<Resource<GifsResponse>> = flow{
//       try {
//           emit(Resource.Loading<GifsResponse>())
//           emit(Resource.Success<GifsResponse>(data =gifRepository.getListOfMemes(type,page,pageSize)))
//
//       } catch(e: HttpException) {
//           emit(Resource.Error<GifsResponse>(e.localizedMessage ?: "An unexpected error occurred"))
//       } catch(e: IOException) {
//           emit(Resource.Error<GifsResponse>("Couldn't reach server. Check your internet connection."))
//       }
//       }
    operator fun invoke(type:String): PagingSource<Int,GifModel>{
        return gifPagingRepository.getMemes(type)
    }

}