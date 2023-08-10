package com.example.rickandmorty.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmorty.data.local.LocalDataSource
import com.example.rickandmorty.data.local.dao.CharacterModelDAO
import com.example.rickandmorty.data.remote.ApiDataSource
import com.example.rickandmorty.data.remote.dto.CharacterModelDTO
import com.example.rickandmorty.data.remote.dto.Data
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.utils.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DataRepositoryImplTest {

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource : LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remote : ApiDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getRemoteList EXPECT Values`() = runTest {
        coEvery { remote.getAllData() } returns getData()
        coEvery { localDataSource.getAll() } returns getLocal()

        val repository = DataRepositoryImpl(
            remote = remote,
            local = localDataSource
        )

        val res = repository.getAllData()

        assertEquals(2, res.size)
    }

    @Test
    fun `WHEN getLocalList EXPECT a specific remoteData`() = runTest {
        coEvery { remote.getAllData() } returns getEmptyData()
        coEvery { localDataSource.getAll() } returns getLocal()

        val repository = DataRepositoryImpl(
            remote = remote,
            local = localDataSource
        )

        val res = repository.getAllData()

        var model = repository.getCharacterDetail(id = 1)

        assertEquals(2, res.size)
        assertEquals(2, res[1].id)

    }

    fun getData() = Data (
        results = List<CharacterModelDTO>(2) {
            CharacterModelDTO(
                id = 99,
                name = "Arthur Schopenhauer",
                status = "Alive",
                species = "Omicron Persei 8",
                gender = "unknow",
                image = "https://url.com",
            )
        }
    )

    fun getEmptyData() = Data (
        results = listOf()
    )

    fun getLocal() = listOf(
        CharacterModelDAO(
            id = 1,
            name = "Steve Harrys",
            status = "Dead",
            specie = "Earth",
            gender = "Male",
            photo = "https://url.com",
            favorite = false,
        ),
        CharacterModelDAO(
            id = 2,
            name = "Dean Torres",
            status = "Alive",
            specie = "Moon",
            gender = "Male",
            photo = "https://url.com",
            favorite = false,
        )
    )

    fun getDetail() = CharacterModelDAO(
        id = 2,
        name = "Dean Torres",
        status = "Alive",
        specie = "Moon",
        gender = "Male",
        photo = "https://url.com",
        favorite = false,
    )
}