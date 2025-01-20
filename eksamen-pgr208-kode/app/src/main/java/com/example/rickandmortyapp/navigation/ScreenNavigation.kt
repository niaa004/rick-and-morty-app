package com.example.rickandmortyapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.screens.characterlist.CharacterListScreen
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterScreen
import com.example.rickandmortyapp.screens.randomcharacter.RandomCharacterScreen
import com.example.rickandmortyapp.screens.savedcharacter.SavedCharacterScreen
import com.example.rickandmortyapp.screens.characterlist.CharacterListViewModel
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.randomcharacter.RandomCharacterViewModel
import com.example.rickandmortyapp.screens.savedcharacter.SavedCharacterViewModel


@Composable
fun ScreenNavigation(
    characterListViewModel: CharacterListViewModel,
    createCharacterViewModel: CreateCharacterViewModel,
    savedCharacterViewModel: SavedCharacterViewModel,
    randomCharacterViewModel: RandomCharacterViewModel
){
    val navController = rememberNavController()
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigationBar( // <- Navigation-bar -> bottom screen
                    navController = navController,
                    selectedTabIndex = selectedTabIndex
                ) { newIndex ->
                    selectedTabIndex = newIndex
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "character_list",
                Modifier.padding(innerPadding)
            ) {
                // Route navigation through screens
                composable("character_list") {
                    CharacterListScreen(characterListViewModel)
                }
                composable("create_character") {
                    CreateCharacterScreen(createCharacterViewModel)
                }
                composable("saved_characters") {
                    SavedCharacterScreen(savedCharacterViewModel)
                }
                composable("random_character") {
                    RandomCharacterScreen(randomCharacterViewModel)
                }

            }
        }
    }





