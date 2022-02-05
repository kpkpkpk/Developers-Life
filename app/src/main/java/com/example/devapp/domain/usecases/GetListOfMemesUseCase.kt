package com.example.devapp.domain.usecases

import com.example.devapp.data.model.GifsResponse
import com.example.devapp.data.repository.GifRepository
import com.example.devapp.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListOfMemesUseCase @Inject constructor(
    private val gifRepository: GifRepository
) {
    operator fun invoke(type:String, page:Int): Flow<Resource<GifsResponse>> {
       return gifRepository.getListOfMemes(type,page)
    }
}