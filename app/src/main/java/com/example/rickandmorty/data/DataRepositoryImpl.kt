package com.example.rickandmorty.data

import com.example.rickandmorty.data.mappers.toModel
import com.example.rickandmorty.data.remote.ApiDataSource
import com.example.rickandmorty.domain.model.CharacterModel

class DataRepositoryImpl(
    private val remote : ApiDataSource
) : DataRepository {
    /*override suspend fun getAllData(): List<CharacterModel> = if(remote.getAllData().results.isNotEmpty()) {
        remote.getAllData().results.map { it.toModel() }
    } else {
        listOf()
    }*/

    override suspend fun getAllData(): List<CharacterModel> {
        return if(remote.getAllData().results.isNotEmpty()) {
            remote.getAllData().results.map { it.toModel() }
        } else {
            listOf()
        }
    }
}