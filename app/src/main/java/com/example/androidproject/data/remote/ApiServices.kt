package com.example.androidproject.data.remote

import com.example.androidproject.data.remote.dto.Post
import retrofit2.http.GET

interface ApiServices {
    @GET("/")
    suspend fun getPosts():List<Post>
}