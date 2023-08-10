package com.example.rickandmorty.presentation.list.all

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmorty.domain.usecase.DeleteCharacterByIdUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.domain.usecase.ResetListUseCase
import com.example.rickandmorty.utils.MainDispatcherRule
import com.example.rickandmorty.utils.TestBuilder
import com.example.rickandmorty.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharacterListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getCharacterListUseCase : GetCharacterListUseCase

    @MockK(relaxed = true)
    private lateinit var deleteUseCase : DeleteCharacterByIdUseCase

    @MockK(relaxed = true)
    private lateinit var resetUseCase : ResetListUseCase

    private lateinit var dispacher : CoroutineDispatcher


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispacher = Dispatchers.IO
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest() {
        coEvery { getCharacterListUseCase.getCharacters() } returns TestBuilder()
            .withElements(16)
            .buildModelList()

        val viewModel = CharacterListViewModel(getCharacterListUseCase, deleteUseCase, resetUseCase, dispacher)

        val response = viewModel.data.getOrAwaitValue()

        Assert.assertEquals(15, response.size)
    }

    @Test
    fun `WHEN viewModel start EXPECT not empty list`() = runTest() {
        coEvery { resetUseCase.resetList() } returns TestBuilder()
            .withElements(18)
            .buildModelList()

        val viewModel = CharacterListViewModel(getCharacterListUseCase, deleteUseCase, resetUseCase)

        val response = viewModel.data.getOrAwaitValue()

        Assert.assertEquals(18, response.size)
    }
}