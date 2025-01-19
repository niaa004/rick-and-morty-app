package com.example.rickandmortyapp.screens.characterlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.rickandmortyapp.components.CharacterItem

// Characters fra APIet
@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel) {
    LaunchedEffect(Unit) {
        viewModel.loadCharactersFromApi()
    }


    // oppdaterer fra ViewModel
    val characters by viewModel.characters.collectAsState()

    Column {
        Text(
            text = "Rick and Morty Characters", // <- Overskrift
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button( // <- Knapp for tilbake til forrige side
                onClick = {
                    viewModel.loadPreviousPage()
                }
            ) {
                Text(text = "Previous Page",
                    fontWeight = FontWeight.Bold
                    )
            }

            Button( // <- Knapp for neste side
                onClick = {
                    viewModel.loadNextPage() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(250, 145, 70),
                    contentColor = Color(255, 255, 255)),
            ) {
                Text(
                    text = "Next Page",
                    fontWeight = FontWeight.Bold
                )
            }
        }

            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                items(characters){ character ->
                    CharacterItem(character)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
                }
            }







