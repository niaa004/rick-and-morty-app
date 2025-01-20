package com.example.rickandmortyapp.components

import com.example.rickandmortyapp.data.dataclasses.Character
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun CharacterItem(character: Character) {
    // Viser informasjon om en enkelt character
    Column {
        Text(text = "ID: ${character.id}")
        Text(text = "Name: ${character.name}")
        Text(text = "Status: ${character.status}")
        Text(text = "Species: ${character.species}")
        Text(text = "Type: ${character.type}")
        Text(text = "Gender: ${character.gender}")
        Text(text = "Origin: ${character.origin.name}")
        Text(text = "Location: ${character.location.name}")

        // Image -> episodes by one single character
        AsyncImage(
            model = character.image,
            contentDescription = "Image of: ${character.name}"
        )

        Text(text = "Episodes:")
        character.episode.forEach{ episodeUrl ->
            Text(text = episodeUrl)
        }

        Text(text = "URL: ${character.url}")
        Text(text = "Created: ${character.created}")
        }
    }






