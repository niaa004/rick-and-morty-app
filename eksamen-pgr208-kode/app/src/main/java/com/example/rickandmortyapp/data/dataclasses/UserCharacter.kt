package com.example.rickandmortyapp.data.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_character") // <- Dataclass character user has saved in database
data class UserCharacter(
    @PrimaryKey(autoGenerate = true) // <- Automatic generated Primary Key (PK) = ID
    val id: Int = 0,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val created: String
)
