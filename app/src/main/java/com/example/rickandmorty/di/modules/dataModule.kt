package com.example.rickandmorty.di.modules

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.data.DataRepository
import com.example.rickandmorty.data.DataRepositoryImpl
import com.example.rickandmorty.data.local.ApiDAO
import com.example.rickandmorty.data.local.LocalDataBase
import com.example.rickandmorty.data.local.LocalDataSource
import com.example.rickandmorty.data.local.LocalDataSourceImpl
import com.example.rickandmorty.data.remote.ApiClient
import com.example.rickandmorty.data.remote.ApiDataSource
import com.example.rickandmorty.data.remote.ApiDataSourceImpl
import com.example.rickandmorty.utils.UtilsBuild
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single <Retrofit> {
        Retrofit.Builder()
            .baseUrl(UtilsBuild.URL_API)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single <Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single <DataRepository>{ DataRepositoryImpl(get(), get()) }

    single <ApiDataSource> { ApiDataSourceImpl(get()) }

    single <ApiClient> { getApi(get()) }

    single <LocalDataSource>{ LocalDataSourceImpl(get()) }

    single { getDataBase(get()) }

    single { getApiDao(get()) }
}

// retrofit instance
private fun getApi(retrofit: Retrofit) = retrofit.create(ApiClient::class.java)

private fun getDataBase(context: Context) : LocalDataBase =
    Room.databaseBuilder(
        context,
        LocalDataBase::class.java, "rickandmorty-db"
    ).build()

private fun getApiDao(dataBase: LocalDataBase) : ApiDAO = dataBase.getApiDAO()