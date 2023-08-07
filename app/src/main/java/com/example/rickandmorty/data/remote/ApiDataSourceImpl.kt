package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.remote.dto.Data

class ApiDataSourceImpl(
    private val apiClient : ApiClient
) : ApiDataSource{
    override suspend fun getAllData(): Data = apiClient.getAllData()
}