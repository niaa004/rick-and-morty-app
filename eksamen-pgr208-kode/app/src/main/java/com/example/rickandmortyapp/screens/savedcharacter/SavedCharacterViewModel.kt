package com.example.rickandmortyapp.screens.savedcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.UserCharacter
import com.example.rickandmortyapp.data.room.UserCharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel som håndterer brukers lagret av nye characters
class SavedCharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<UserCharacter>>(emptyList())
    val characters: StateFlow<List<UserCharacter>> = _characters

    // Laster alle characters som er lagret fra databasen
    fun loadSavedCharacters() {
        viewModelScope.launch {
            _characters.value = UserCharacterRepository.getUserCharacters() // <- resultatet i StateFlow
        }
    }
}
