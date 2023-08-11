package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.model.CharacterModelAdd

class GetNewCharacterUseCase(
    private val repository : DataRepository
) {
    suspend fun addNewCharacter(character: CharacterModelAdd)  = repository.insertNewCharacter(character)
}