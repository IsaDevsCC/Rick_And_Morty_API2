package com.example.rickandmorty.data.local.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterModelDAO(
    @PrimaryKey @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "status") val status : String,
    @ColumnInfo(name = "specie") val specie : String,
    @ColumnInfo(name = "gender") val gender : String,
    @ColumnInfo(name = "photo") val photo : String,
)
