package com.example.rickandmortyapp.screens.savedcharacter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.UserCharacterItem

@Composable
fun SavedCharacterScreen(viewModel: SavedCharacterViewModel) {
    val characters by viewModel.characters.collectAsState() // <- saved characters fra viewModel

    Column {
        Text(
            text = "Saved Characters", // <- Overskrift
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            fontSize = 18.sp,
            color = Color(250, 145, 70),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )

        // Henter saved characters
    LaunchedEffect(Unit) {
        viewModel.loadSavedCharacters()
    }

        // Viser characters i en liste
    LazyColumn {
        items(characters) { character ->
            UserCharacterItem(character)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
}

