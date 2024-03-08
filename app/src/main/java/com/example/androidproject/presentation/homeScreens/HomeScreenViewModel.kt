package com.example.androidproject.presentation.homeScreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.data.remote.dto.Post
import com.example.androidproject.domain.repositorys.ApiServicesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(private val repo:ApiServicesRepository): ViewModel() {
    var list = emptyList<Post>()

    fun getPosts(){
        viewModelScope.launch (Dispatchers.IO){
            list = repo.getPosts()
        }
    }

}