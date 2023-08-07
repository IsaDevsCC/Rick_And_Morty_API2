package com.example.rickandmorty.domain.model

data class CharacterModel(
    val id : Int,
    val name : String,
    val status : String,
    val specie : String,
    val genre : String,
    val photo : String,
)
