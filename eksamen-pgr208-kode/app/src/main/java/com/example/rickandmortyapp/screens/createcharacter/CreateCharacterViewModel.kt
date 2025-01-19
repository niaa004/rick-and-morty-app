package com.example.rickandmortyapp.screens.createcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.UserCharacter
import com.example.rickandmortyapp.data.room.UserCharacterRepository
import kotlinx.coroutines.launch

// ViewModel håndterer brukers opprettelse av nye characters
class CreateCharacterViewModel : ViewModel() {

    fun saveCharacter(character : UserCharacter) { // <- Lagrer til databasen
        viewModelScope.launch {
            UserCharacterRepository.insertUserCharacter(character)
        }
    }
}