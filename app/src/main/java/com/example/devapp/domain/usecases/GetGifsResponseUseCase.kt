package com.example.devapp.domain.usecases

import com.example.devapp.data.utils.Resource
import com.example.devapp.domain.model.GifsResponse
import com.example.devapp.domain.repository.GifRepository
import javax.inject.Inject

class GetGifsResponseUseCase @Inject constructor(
    private val gifRepository: GifRepository,
) {
    suspend operator fun invoke(type: String, page: Int, pageSize: Int):GifsResponse{
        return when(val response = gifRepository.getGifsResponse(type, page, pageSize)){
            is Resource.Success -> response.data!!
            is Resource.Error -> throw response.error
        }
    }


}