package com.example.androidproject.data.repositorys

import com.example.androidproject.data.remote.ApiServices
import com.example.androidproject.data.remote.dto.Post
import com.example.androidproject.domain.repositorys.ApiServicesRepository
import javax.inject.Inject

class ApiServicesRepositoryImpl @Inject constructor(private val api:ApiServices) : ApiServicesRepository {
    override suspend fun getPosts(): List<Post> {

        var list = emptyList<Post>()

        try {
            list = api.getPosts()
        }
        catch(e:Exception) {
            return list
        }

        return list
    }
}