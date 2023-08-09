package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.domain.model.CharacterModel

class GetFavListUseCase(
    private val repository: DataRepository
) {

    suspend fun getFavList() : List<CharacterModel> = repository.getFavList()
}