package com.example.rickandmortyapp.data.room

import android.content.Context
import androidx.room.Room
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

object UserCharacterRepository { // <- Singleton-class for Room-databasen
    private lateinit var _rickAndMortyDatabase: RickAndMortyDatabase // <- database instans
    private val _userCharacterDao by lazy { _rickAndMortyDatabase.userCharacterDao() // <- DAO
    }

    // Initialiserer databasen
    fun initializeDatabase(context: Context) {
        _rickAndMortyDatabase = Room.databaseBuilder(
            context.applicationContext,
            RickAndMortyDatabase::class.java,
            "rick-and-morty-database"
        )
            .build()
    }

    // Setter inn character i databasen
    suspend fun insertUserCharacter(character: UserCharacter): Long {
        return try {
            _userCharacterDao.insertUserCharacter(character)
        } catch (e: Exception) {
            -1L // <- (-1) return dersom feil
        }
    }

    suspend fun getUserCharacters(): List<UserCharacter> {
        return try {
            _userCharacterDao.getAllUserCharacters()
        } catch (e: Exception) {
            emptyList() // <- (empty) return dersom feil
        }
    }

}