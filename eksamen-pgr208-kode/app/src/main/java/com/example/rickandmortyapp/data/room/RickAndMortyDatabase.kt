package com.example.rickandmortyapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

@Database( // <- Room-databse
    entities = [UserCharacter::class],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase(){
    abstract fun userCharacterDao(): UserCharacterDao // <- DAO return to UserCharacter
}