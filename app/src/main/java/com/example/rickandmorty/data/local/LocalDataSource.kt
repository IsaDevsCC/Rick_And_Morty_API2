package com.example.rickandmorty.data.local

import com.example.rickandmorty.data.local.dao.CharacterModelDAO

interface LocalDataSource {

    suspend fun getAll() : List<CharacterModelDAO>
    suspend fun insertAll(list: List<CharacterModelDAO>)
    suspend fun getCharacterById(id : Int): CharacterModelDAO
    suspend fun addToFavCharacter(id: Int, fav : Boolean)
    suspend fun getFavList() : List<CharacterModelDAO>
    suspend fun deleteById(id : Int)
}