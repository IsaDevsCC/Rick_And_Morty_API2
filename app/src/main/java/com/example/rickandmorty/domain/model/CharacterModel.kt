package com.example.rickandmorty.domain.model



data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val photo: String,
    val favorite : Boolean,
    //val location: List<Locations>?,
    //val origin: List <OriginModel>,
)/*{
    data class LocationModel (
        val name : String,
    )

    data class OriginModel (
        val name : String,
    )
}*/

