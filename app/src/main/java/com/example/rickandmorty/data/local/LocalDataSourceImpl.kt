package com.example.rickandmorty.data.local

import com.example.rickandmorty.data.local.dao.CharacterModelDAO

class LocalDataSourceImpl(
    private val apiDAO: ApiDAO
) : LocalDataSource {

    override suspend fun getAll(): List<CharacterModelDAO> = apiDAO.getAllCharacters()
    override suspend fun insertAll(list: List<CharacterModelDAO>) = apiDAO.insertInto(list)
    override suspend fun getCharacterById(id: Int): CharacterModelDAO = apiDAO.getByCharacterById(id)
    override suspend fun addToFavCharacter(id: Int, fav: Boolean) = apiDAO.addCharacterToAdd(id,fav)
    override suspend fun getFavList(): List<CharacterModelDAO> = apiDAO.getFavList()
    override suspend fun deleteById(id: Int) = apiDAO.deleteById(id)
    override suspend fun deleteAll() = apiDAO.deleteAll()

}