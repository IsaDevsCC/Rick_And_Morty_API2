package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository


class AddToFavUseCase(
    private val repository : DataRepository
) {
    suspend fun addCharacterToFav(id : Int, fav : Boolean) = repository.addCharacterToFav(id, fav)
}