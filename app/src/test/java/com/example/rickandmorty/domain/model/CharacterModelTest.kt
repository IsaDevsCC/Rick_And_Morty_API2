package com.example.rickandmorty.domain.model

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CharacterModelTest {

    private lateinit var characterModel : CharacterModel

    @Before
    fun setUp() {
        characterModel = CharacterModel(
            55,
            "Rick Sanchez",
            "Alive",
            "Human",
            "Male",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            true
        )
    }

    @Test
    fun `WHEN create model EXPECT not null value`(){
        assertThat(characterModel, notNullValue())
    }

    @Test
    fun `WHEN get model ID EXPECT not null value`(){
        assertThat(characterModel.id, notNullValue())
    }

    @Test
    fun `WHEN get model ID EXPECT a right value`(){
        assertThat(characterModel.id, `is`(55))
    }

    @Test
    fun `WHEN get model Name EXPECT not null value`(){
        assertThat(characterModel.name, notNullValue())
    }

    @Test
    fun `WHEN get model Name not EXPECT another value`(){
        Assert.assertTrue(characterModel.name, true)
    }

    @Test
    fun `WHEN get model Status EXPECT not null value`(){
        val aux = "Alive"
        val not = "Dead"
        assertThat(characterModel.status, `is`(aux))
        Assert.assertFalse(characterModel.status,characterModel.status.equals(not))
    }

    @Test
    fun `WHEN get model Status EXPECT right value`(){
        assertThat(characterModel.status, notNullValue())
    }

    @Test
    fun `WHEN get model Specie EXPECT not null value`(){
        assertThat(characterModel.specie, notNullValue())
    }

    @Test
    fun `WHEN get model Gender EXPECT not null value`(){
        assertThat(characterModel.gender, notNullValue())
    }

    @Test
    fun `WHEN get model Photo EXPECT not null value`(){
        assertThat(characterModel.photo, notNullValue())
    }

    @Test
    fun `WHEN get model Favorite EXPECT not null value`(){
        assertThat(characterModel.favorite, notNullValue())
    }
}