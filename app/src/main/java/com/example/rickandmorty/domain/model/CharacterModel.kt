package com.example.rickandmorty.domain.model



data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val photo: String,
    val favorite : Boolean,
)

data class CharacterModelAdd(
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val photo: String,
    val favorite : Boolean,
)

