package com.example.rickandmortyapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

@Dao // <- DAO (Data Access Object) -> Communicate with database
interface UserCharacterDao {

        // Gets all characters in database with SELECT * FROM
        @Insert
        suspend fun insertUserCharacter(character: UserCharacter): Long

        // Adds to new character in the database with "INSERT"
        @Query("SELECT * FROM user_character")
        suspend fun getAllUserCharacters(): List<UserCharacter>

    }
