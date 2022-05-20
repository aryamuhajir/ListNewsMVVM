package com.example.listnewsmvvm.network

import com.example.listnewsmvvm.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponseItem>>
}