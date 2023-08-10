package com.example.rickandmorty.data.mappers

import com.example.rickandmorty.data.local.dao.CharacterModelDAO
import com.example.rickandmorty.data.remote.dto.CharacterModelDTO
import com.example.rickandmorty.domain.model.CharacterModel
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MappersKtTest {

    private var characterDTO : CharacterModelDTO? = null
    private var characterDAO : CharacterModelDAO? = null
    private var characterModel : CharacterModel? = null

    @Before
    fun setUp() {
        characterDTO = CharacterModelDTO(
                id = 99,
                name = "Arthur Schopenhauer",
                status = "Alive",
                species = "Omicron Persei 8",
                gender = "unknow",
                image = "https://url.com",
                )

        characterDAO = CharacterModelDAO(
            id = 1,
            name = "Steve Harrys",
            status = "Dead",
            specie = "Earth",
            gender = "Male",
            photo = "https://url.com",
            favorite = false,
        )

        characterModel = CharacterModel(
            id = 22,
            name = "Alice Chains",
            status = "Alive",
            specie = "Marte",
            gender = "Woman",
            photo = "https://url.com",
            favorite = false,
        )
    }

    @Test
    fun `WHEN map to a CharacterModel EXPECT not empty id`(){

        val characterModel = characterDTO ?: return
        val model = characterModel.toModel()

        assertEquals(99, model.id)
    }

    @Test
    fun `WHEN map to a CharacterModel EXPECT  specific id`(){

        val characterModel = characterDTO ?: return
        val model = characterModel.toModel()

        assertEquals(99, model.id)
    }

    @Test
    fun `WHEN map to a CharacterModelDAO from DTO EXPECT specific species`(){

        val characterModelDAO = characterDTO ?: return
        val model = characterModelDAO.toModelDAO()

        assertEquals("Omicron Persei 8", model.specie)
    }

    @Test
    fun `WHEN map to a CharacterModel from DAO EXPECT has value`(){

        val characterModel = characterDAO ?: return
        val model = characterModel.toModel()

        assertEquals("Steve Harrys", model.name)
    }

    @Test
    fun `WHEN map to a CharacterModelDAO from MODEL EXPECT has value`(){

        val characterModelDAO = characterModel ?: return
        val model = characterModelDAO.toModelDAO()

        assertEquals("https://url.com", model.photo)
    }
}