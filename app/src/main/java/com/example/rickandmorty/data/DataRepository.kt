package com.example.rickandmorty.data

import com.example.rickandmorty.domain.model.CharacterModel

interface DataRepository {
    suspend fun getAllData() : List<CharacterModel>
    suspend fun getCharacterDetail(id : Int) : CharacterModel
    suspend fun addCharacterToFav(id: Int, fav : Boolean)
    suspend fun getFavList() : List<CharacterModel>
    suspend fun deleteById(id : Int)
    suspend fun deleteAll() : List<CharacterModel>
}