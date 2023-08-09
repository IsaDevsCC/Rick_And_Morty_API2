package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class ResetListUseCase(
    private val repository: DataRepository
) {

    suspend fun resetList() : List<CharacterModel> = repository.deleteAll()
}