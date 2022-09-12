package com.hatim.photoplay.di

import com.hatim.photoplay.data.services.DocumentsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMainRetrofit(): Retrofit {
        val builder = OkHttpClient().newBuilder().apply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/launches/")
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDocumentsService(retrofit: Retrofit): DocumentsService =
        retrofit.create(DocumentsService::class.java)
}