package com.example.rickandmorty.data

import com.example.rickandmorty.data.local.LocalDataSource
import com.example.rickandmorty.data.mappers.toModel
import com.example.rickandmorty.data.mappers.toModelDAO
import com.example.rickandmorty.data.remote.ApiDataSource
import com.example.rickandmorty.domain.model.CharacterModel

class DataRepositoryImpl(
    private val remote : ApiDataSource,
    private val local : LocalDataSource
) : DataRepository {

    override suspend fun getAllData(): List<CharacterModel> = if(local.getAll().isNotEmpty()) {
        local.getAll().map { it.toModel() }
    } else {
        local.insertAll(remote.getAllData().results.map { it.toModelDAO() })
        local.getAll().map { it.toModel() }
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel = local.getCharacterById(id).toModel()
    override suspend fun getCharacterByName(name: String): List<CharacterModel> = local.getCharacterByName(name).map { it.toModel() }
}