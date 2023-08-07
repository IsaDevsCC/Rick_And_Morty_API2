package com.example.rickandmorty.data.mappers

import com.example.rickandmorty.data.remote.dto.CharacterModelDTO
import com.example.rickandmorty.domain.model.CharacterModel

fun CharacterModelDTO.toModel() = CharacterModel(
    id = id ?: 0,
    name = name ?: "",
    status = status ?: "",
    specie = species ?: "",
    gender = gender ?: "",
    photo = image ?: "",
)