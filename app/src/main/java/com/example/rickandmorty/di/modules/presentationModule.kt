package com.example.rickandmorty.di.modules

import com.example.rickandmorty.presentation.detail.CharacterDetailViewModel
import com.example.rickandmorty.presentation.list.CharacterListViewModel
import com.example.rickandmorty.presentation.list.FavsListComposeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get()) }
    viewModel { CharacterDetailViewModel(get(), get())}
    viewModel { FavsListComposeViewModel(get()) }
}