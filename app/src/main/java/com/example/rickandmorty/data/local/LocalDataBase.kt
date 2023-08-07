package com.example.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.local.dao.CharacterModelDAO

@Database(entities = [CharacterModelDAO::class], version = 1, exportSchema = true)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun getApiDAO() : ApiDAO
}