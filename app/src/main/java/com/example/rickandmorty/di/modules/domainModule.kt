package com.example.rickandmorty.di.modules

import com.example.rickandmorty.domain.usecase.AddToFavUseCase
import com.example.rickandmorty.domain.usecase.DeleteCharacterByIdUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.domain.usecase.GetFavListUseCase
import com.example.rickandmorty.domain.usecase.GetNewCharacterUseCase
import com.example.rickandmorty.domain.usecase.ResetListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterListUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
    single { AddToFavUseCase(get()) }
    single { GetFavListUseCase(get()) }
    single { DeleteCharacterByIdUseCase(get()) }
    single { ResetListUseCase(get()) }
    single { GetNewCharacterUseCase(get()) }
}