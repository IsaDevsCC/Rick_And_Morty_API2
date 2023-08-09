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
    //location = location ?: null,
    //origin = (origin ?: ",") as List<CharacterModel.OriginModel>
)

/*fun Locations.toLocationModel() = LocationModel (
    name = name ?: "",
)*/

fun CharacterModelDAO.toModel() = CharacterModel (
    id = id,
    name = name ?: "",
    status = status ?: "",
    specie = specie ?: "",
    gender = gender ?: "",
    photo = photo ?: "",
    favorite = favorite,
    //location = locations ?: listOf(),
    //origin = (origins ?: ",") as List<CharacterModel.OriginModel>
)

fun CharacterModelDTO.toModelDAO() = CharacterModelDAO(
    id = id ?: 0,
    name = name ?: "",
    status = status ?: "",
    specie = species ?: "",
    gender = gender ?: "",
    photo = image ?: "",
    favorite = false,
    //locations = location ?: null,
    //origins = (origin ?: ",") as List<CharacterModel.OriginModel>
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