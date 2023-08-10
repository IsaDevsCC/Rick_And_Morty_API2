package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetNewCharacterUseCase(
    private val repository : DataRepository
) {

    suspend fun addNewCharacter(character : CharacterModel)  = repository.insertNewCharacter(character)
}