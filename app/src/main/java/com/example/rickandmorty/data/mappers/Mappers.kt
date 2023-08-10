package com.example.rickandmorty.data.mappers

import com.example.rickandmorty.data.local.dao.CharacterModelDAO
import com.example.rickandmorty.data.remote.dto.CharacterModelDTO
import com.example.rickandmorty.domain.model.CharacterModel

fun CharacterModelDTO.toModel() = CharacterModel(
    id = id ?: 0,
    name = name ?: "",
    status = status ?: "",
    specie = species ?: "",
    gender = gender ?: "",
    photo = image ?: "",
    favorite = false
)


fun CharacterModelDAO.toModel() = CharacterModel (
    id = id,
    name = name ?: "",
    status = status ?: "",
    specie = specie ?: "",
    gender = gender ?: "",
    photo = photo ?: "",
    favorite = favorite,
)

fun CharacterModelDTO.toModelDAO() = CharacterModelDAO(
    id = id ?: 0,
    name = name ?: "",
    status = status ?: "",
    specie = species ?: "",
    gender = gender ?: "",
    photo = image ?: "",
    favorite = false,
)

fun CharacterModel.toModelDAO() = CharacterModelDAO(
    id = id,
    name = name,
    status = status,
    specie = specie,
    gender = gender,
    photo = photo,
    favorite = favorite,
)