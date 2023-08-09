package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetByNameUseCase(
    private val repository : DataRepository
) {

    suspend fun getByCharacterName(name : String) : List<CharacterModel> = repository.getCharacterByName(name)
}