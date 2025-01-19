package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.data.room.UserCharacterRepository
import com.example.rickandmortyapp.screens.characterlist.CharacterListViewModel
import com.example.rickandmortyapp.navigation.ScreenNavigation
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.randomcharacter.RandomCharacterViewModel
import com.example.rickandmortyapp.screens.savedcharacter.SavedCharacterViewModel
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme


class MainActivity : ComponentActivity() {
    // ViewModels - arkitektur
    private val characterListViewModel: CharacterListViewModel by viewModels()
    private val createCharacterViewModel: CreateCharacterViewModel by viewModels()
    private val savedCharacterViewModel : SavedCharacterViewModel by viewModels()
    private val randomCharacterViewModel : RandomCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UserCharacterRepository.initializeDatabase(applicationContext) // <- Initierer databasen

        setContent {
            RickAndMortyAppTheme {
                ScreenNavigation( // <- Navigasjon mellom skjermene
                    characterListViewModel = characterListViewModel,
                    createCharacterViewModel = createCharacterViewModel,
                    savedCharacterViewModel = savedCharacterViewModel,
                    randomCharacterViewModel = randomCharacterViewModel
                )
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text(
            color = Color(250, 145, 70),
            text = "Welcome to the world Rick and Morty World!",
            modifier = modifier.padding(24.dp)
        )
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyAppTheme {
        Greeting()
    }
}










