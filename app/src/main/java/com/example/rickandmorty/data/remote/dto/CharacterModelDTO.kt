package com.example.rickandmorty.data.remote.dto

import com.squareup.moshi.Json

data class Data (
    @Json(name = "info") val info: Info,
    @Json(name = "results") val results: List<CharacterModelDTO>
)

data class Info(
    @Json(name = "count") val count : Int,
    @Json(name = "pages") val id : Int,
    @Json(name = "next") val name : String,
    @Json(name = "prev") val status : String?,
)

data class CharacterModelDTO (
    @Json(name = "id") val id : Int?,
    @Json(name = "name") val name : String?,
    @Json(name = "status") val status : String?,
    @Json(name = "species") val species : String?,
    @Json(name = "gender") val gender : String?,
    //@Json(name = "origin") val origin : List<Origins>?,
    //@Json(name = "location") val location : List<Locations>?,
    @Json(name = "image") val image : String?,
    //@Json(name = "id") val id : Int,
)

/*data class Origins (
    @Json(name = "name") val name : String?,
    //@Json(name = "url") val url : String?
)

data class Locations (
    @Json(name = "name") val name : String?,
    //@Json(name = "url") val url : String?
)*/