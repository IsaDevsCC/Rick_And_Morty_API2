package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetCharacterListUseCase(
    private val repository : DataRepository
) {

    suspend fun getCharacters() : List<CharacterModel> = repository.getAllData()
}