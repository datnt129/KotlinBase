package com.example.demoretrofit.retrofit

import com.example.demoretrofit.Album
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IAlbumApi {
    companion object {
        private const val baseUrl = "https://jsonplaceholder.typicode.com/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val alBumApi = retrofit.create(IAlbumApi::class.java)
    }
    @GET("photos")
    fun getPhotos(): Call<List<Album>>
}