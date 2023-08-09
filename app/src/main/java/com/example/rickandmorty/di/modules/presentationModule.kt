package com.example.rickandmorty.di.modules

import com.example.rickandmorty.presentation.adding.AddNewCharacterViewModel
import com.example.rickandmorty.presentation.detail.CharacterDetailViewModel
import com.example.rickandmorty.presentation.list.all.CharacterListViewModel
import com.example.rickandmorty.presentation.list.favs.FavsListComposeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get(), get(), get()) }
    viewModel { CharacterDetailViewModel(get(), get())}
    viewModel { FavsListComposeViewModel(get()) }
    viewModel { AddNewCharacterViewModel() }
}