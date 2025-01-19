package com.example.rickandmortyapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

@Dao // <- DAO (Data Access Object) -> kommuniserer med databasen
interface UserCharacterDao {

        // Henter alle characters i databasen med SELECT * FROM
        @Insert
        suspend fun insertUserCharacter(character: UserCharacter): Long

        // Legger til ny character i databasen med "INSERT"
        @Query("SELECT * FROM user_character")
        suspend fun getAllUserCharacters(): List<UserCharacter>

    }
