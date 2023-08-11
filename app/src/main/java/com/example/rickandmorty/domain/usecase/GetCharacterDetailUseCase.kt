package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetCharacterDetailUseCase(
    private val repository : DataRepository
) {
    suspend fun getCharacterDetail(id : Int) : CharacterModel = repository.getCharacterDetail(id)
}