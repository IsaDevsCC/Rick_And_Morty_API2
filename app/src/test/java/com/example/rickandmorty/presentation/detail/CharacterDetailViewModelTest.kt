package com.example.rickandmorty.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmorty.domain.usecase.AddToFavUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmorty.utils.MainDispatcherRule
import com.example.rickandmorty.utils.TestBuilder
import com.example.rickandmorty.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharacterDetailViewModelTest {

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getDetailUseCase : GetCharacterDetailUseCase

    @MockK(relaxed = true)
    private lateinit var addToFavUseCase : AddToFavUseCase


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN call to Detail EXPECT the correct DetailId`() = runTest {
        coEvery { getDetailUseCase.getCharacterDetail(55) } returns TestBuilder().withFavorite(true).buildModel()

        val viewModel = CharacterDetailViewModel(getDetailUseCase, addToFavUseCase)

        viewModel.getDetail(55)

        val res = viewModel.data.getOrAwaitValue()

        assertThat(res.id, `is`(55))


    }

    @Test
    fun `WHEN add to fav EXPECT a change to value`() = runTest {
        coEvery { getDetailUseCase.getCharacterDetail(55) } returns TestBuilder().withFavorite(true).buildModel()

        val viewModel = CharacterDetailViewModel(getDetailUseCase, addToFavUseCase)

        viewModel.getDetail(55)

        val res = viewModel.data.getOrAwaitValue()

        viewModel.addToFavCharacter(res.id, true)

        viewModel.set.getOrAwaitValue()

        assertThat(res.favorite, `is`(true))
    }
}