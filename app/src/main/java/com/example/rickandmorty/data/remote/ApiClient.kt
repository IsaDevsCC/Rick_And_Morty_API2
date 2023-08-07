package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.remote.dto.Data
import retrofit2.http.GET

interface ApiClient {

    @GET("character")
    suspend fun getAllData() : Data
}