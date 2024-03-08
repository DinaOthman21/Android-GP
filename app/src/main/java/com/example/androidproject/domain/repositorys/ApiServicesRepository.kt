package com.example.androidproject.domain.repositorys

import com.example.androidproject.data.remote.dto.Post

interface ApiServicesRepository {
    suspend fun getPosts() : List<Post>
}