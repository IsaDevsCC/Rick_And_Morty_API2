package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.DataRepository

class DeleteCharacterByIdUseCase(
    private val repository : DataRepository
) {

    suspend fun deletebyId(id : Int) = repository.deleteById(id)
}