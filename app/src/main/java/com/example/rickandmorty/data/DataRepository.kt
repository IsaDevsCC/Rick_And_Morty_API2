package com.example.rickandmorty.data

import com.example.rickandmorty.domain.model.CharacterModel

interface DataRepository {

    suspend fun getAllData() : List<CharacterModel>
    suspend fun getCharacterDetail(id : Int) : CharacterModel
    suspend fun getCharacterByName(name: String): List<CharacterModel>
}