package com.example.rickandmorty.di.modules

import com.example.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterListUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
}