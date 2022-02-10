package com.example.devapp.data.utils

import com.example.devapp.domain.model.GifModel
import com.example.devapp.domain.model.response.GifResponse

internal fun GifResponse.toGifModel(): GifModel = GifModel(
    id = id!!,
    description = description!!,
    votes = votes!!,
    author = author!!,
    date = date!!,
    gifURL = gifURL,
    gifSize = gifSize!!,
    previewURL = previewURL!!,
    videoURL = videoURL,
    videoPath = videoPath,
    videoSize = videoSize,
    type = type!!,
    width = width!!,
    height = height!!,
    commentsCount = commentsCount!!,
    fileSize = fileSize!!,
    canVote = canVote!!
)