package com.example.androidproject.di

import com.example.androidproject.data.Constants
import com.example.androidproject.data.remote.ApiServices
import com.example.androidproject.data.repositorys.ApiServicesRepositoryImpl
import com.example.androidproject.domain.repositorys.ApiServicesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
class AppModule {
    // general Api services
    @Provides
    @Singleton
    fun providesRetrofit (): Retrofit = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesApiServices() : ApiServices = providesRetrofit().create(ApiServices::class.java)

    @Provides
    @Singleton
    fun providesApiServicesRepository(): ApiServicesRepository = ApiServicesRepositoryImpl(providesApiServices())
}