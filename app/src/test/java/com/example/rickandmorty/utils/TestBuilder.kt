package com.example.rickandmorty.utils

import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.model.CharacterModelAdd

class TestBuilder {
    val id: Int = 55
    var name: String = ""
    var status: String = ""
    var specie: String = ""
    var gender: String = ""
    var photo: String = ""
    var favorite : Boolean = false
    var elements : Int = 10

    fun withName(name : String) : TestBuilder {
        this.name = name
        return this
    }

    fun withStatus(status : String) : TestBuilder {
        this.status = status
        return this
    }

    fun withSpecie(specie : String) : TestBuilder {
        this.specie = specie
        return this
    }

    fun withGender(gender : String) : TestBuilder {
        this.gender = gender
        return this
    }

    fun withPhoto(photo : String) : TestBuilder {
        this.photo = photo
        return this
    }

    fun withFavorite(favorite : Boolean) : TestBuilder {
        this.favorite = favorite
        return this
    }

    fun withElements(elements : Int) : TestBuilder {
        this.elements = elements
        return this
    }

    fun buildModel() = CharacterModel(
        id = id,
        name = name,
        status = status,
        specie = specie,
        gender = gender,
        photo = photo,
        favorite = favorite
    )

    fun buildModelAdd() = CharacterModelAdd(
        name = name,
        status = status,
        specie = specie,
        gender = gender,
        photo = photo,
        favorite = favorite
    )

    fun buildModelList() : List<CharacterModel> {
        val list = mutableListOf<CharacterModel>()

        for(i in 0 until elements) {
            list.add(
                CharacterModel(
                    id,
                    name,
                    status,
                    specie,
                    gender,
                    photo,
                    favorite
                )
            )
        }

        return list.toList()
    }
}