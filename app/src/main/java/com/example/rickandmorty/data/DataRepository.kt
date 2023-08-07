package com.example.rickandmorty.data

import com.example.rickandmorty.domain.model.CharacterModel

interface DataRepository {

    suspend fun getAllData() : List<CharacterModel>
}