package com.example.rickandmorty.presentation.adding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetNewCharacterUseCase
import com.example.rickandmorty.utils.MainDispatcherRule
import com.example.rickandmorty.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddNewCharacterViewModelComposeTest {

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var useCase: GetNewCharacterUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    /*
    *
    * - Al ser un Void y sin saber muy bien
    * */
    @Test
    fun `WHEN call to Add EXPECT the correct size list`() = runTest {
        coEvery { useCase.addNewCharacter(characterModel()) }

        val viewModel = AddNewCharacterViewModelCompose(useCase)

        viewModel.addNewCharacter(characterModel())

        viewModel.character.getOrAwaitValue()

        assertThat(22,`is`(viewModel.character.value?.id))

    }

    fun characterModel() = CharacterModel(
        id = 22,
        name = "Alice Chains",
        status = "Alive",
        specie = "Marte",
        gender = "Woman",
        photo = "https://url.com",
        favorite = false,
    )
}