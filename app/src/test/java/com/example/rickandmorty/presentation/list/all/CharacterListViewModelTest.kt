package com.example.rickandmorty.presentation.list.all

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmorty.domain.usecase.DeleteCharacterByIdUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.domain.usecase.ResetListUseCase
import com.example.rickandmorty.utils.DefaultDispatcherRule
import com.example.rickandmorty.utils.TestBuilder
import com.example.rickandmorty.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class CharacterListViewModelTest {

    @get : Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get : Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getCharacterListUseCase : GetCharacterListUseCase

    @MockK(relaxed = true)
    private lateinit var deleteUseCase : DeleteCharacterByIdUseCase

    @MockK(relaxed = true)
    private lateinit var resetUseCase : ResetListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = run {
        coEvery { getCharacterListUseCase.getCharacters() } returns TestBuilder()
            .withElements(18)
            .buildModelList()

        val viewModel = CharacterListViewModel(getCharacterListUseCase, deleteUseCase, resetUseCase)

        val response = viewModel.data.getOrAwaitValue()

        Assert.assertEquals(response.size, 18)
    }
}