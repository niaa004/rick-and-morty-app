package com.example.rickandmortyapp.screens.randomcharacter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.CharacterItem

@Composable
fun RandomCharacterScreen(viewModel: RandomCharacterViewModel) {
    val randomCharacter by viewModel.randomCharacter.collectAsState() // <- saved characters fra viewModel

    Column {
        Text(
            text = "Get Random Character", // <- Overskrift
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Button(onClick = { viewModel.loadRandomCharacter() }, // <- Generer tilfeldig character
                colors = ButtonDefaults.buttonColors(
                containerColor = Color(250, 145, 70),
                contentColor = Color(255, 255, 255)),
        ) {
            Text(
                text = "Generator++",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (randomCharacter != null) { // <- viser random character, og teksten forsvinner
            CharacterItem(
                character = randomCharacter!!)
        } else {
            Text(
                text = "Push the button to get a random character!",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        }
    }
}