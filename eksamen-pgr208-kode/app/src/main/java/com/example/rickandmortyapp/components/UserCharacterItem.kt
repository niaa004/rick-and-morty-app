package com.example.rickandmortyapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

// Viser informasjon om en enkelt character i databasen
@Composable
fun UserCharacterItem(character: UserCharacter) {
    Column {
        Text(text = "ID: ${character.id}")
        Text(text = "Name: ${character.name}")
        Text(text = "Status: ${character.status}")
        Text(text = "Species: ${character.species}")
        Text(text = "Type: ${character.type}")
        Text(text = "Gender: ${character.gender}")
        Text(text = "Origin: ${character.origin}")
        Text(text = "Location: ${character.location}")
        Text(text = "Created: ${character.created}")
    }
}