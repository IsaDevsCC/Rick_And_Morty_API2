package com.example.rickandmorty.data

import com.example.rickandmorty.data.local.LocalDataSource
import com.example.rickandmorty.data.mappers.toModel
import com.example.rickandmorty.data.mappers.toModelDAO
import com.example.rickandmorty.data.remote.ApiDataSource
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.model.CharacterModelAdd

class DataRepositoryImpl(
    private val remote : ApiDataSource,
    private val local : LocalDataSource
) : DataRepository {

// TODO ---> VALIDACIÓN DE ERRORES DESDE ACA!!!
    override suspend fun getAllData(): List<CharacterModel> = if(local.getAll().isNotEmpty()) {
        local.getAll().map { it.toModel() }
    } else {
        local.insertAll(remote.getAllData().results.map { it.toModelDAO() })
        local.getAll().map { it.toModel() }
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel = local.getCharacterById(id).toModel()
    override suspend fun addCharacterToFav(id: Int, fav: Boolean) = local.addToFavCharacter(id, fav)
    override suspend fun getFavList(): List<CharacterModel> = local.getFavList().map { it.toModel() }
    override suspend fun deleteById(id: Int) = local.deleteById(id)
    override suspend fun deleteAll() : List<CharacterModel> {
        local.deleteAll()
        local.insertAll(remote.getAllData().results.map { it.toModelDAO() })

        return local.getAll().map { it.toModel() }
    }

    override suspend fun insertNewCharacter(characterModel: CharacterModelAdd) = local.insertNewCharacter(characterModel.toModelDAO())


}