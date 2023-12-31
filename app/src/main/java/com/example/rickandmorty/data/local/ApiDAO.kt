package com.example.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.local.dao.CharacterModelDAO

@Dao
interface ApiDAO {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters() : List <CharacterModelDAO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInto(list: List<CharacterModelDAO>)

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getByCharacterById(id : Int) : CharacterModelDAO

    @Query("UPDATE characters SET favorite = :fav WHERE id = :id")
    suspend fun addCharacterToAdd(id : Int, fav : Boolean)

    @Query("SELECT * FROM characters WHERE favorite = 1")
    suspend fun getFavList() : List<CharacterModelDAO>

    @Query("DELETE FROM characters WHERE id = :id")
    suspend fun deleteById(id : Int)

    @Query("DELETE FROM characters")
    suspend fun deleteAll()

    @Insert
    suspend fun insertNewCharacter(characterModelDAO: CharacterModelDAO)
}

