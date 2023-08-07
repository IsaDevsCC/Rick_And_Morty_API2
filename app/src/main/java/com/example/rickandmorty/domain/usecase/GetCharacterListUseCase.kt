package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetCharacterListUseCase(
    //private val repository : DataRepository
) {

    //suspend fun getCharacters() : List<CharacterModel> = repository.getAllData()
    fun getCharacters() : List<CharacterModel> = List(25) {
        CharacterModel(
            1,
            "Rick Sanchez",
            "Alive",
            "Human",
            "Male",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
    }
}