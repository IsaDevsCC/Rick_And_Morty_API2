package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.local.dao.CharacterModelDAO
import com.example.rickandmorty.data.remote.dto.Data

interface ApiDataSource {
    suspend fun getAllData() : Data

}