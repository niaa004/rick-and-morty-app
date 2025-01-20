package com.example.rickandmortyapp.screens.savedcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.UserCharacter
import com.example.rickandmortyapp.data.room.UserCharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel handles saved characters by user
class SavedCharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<UserCharacter>>(emptyList())
    val characters: StateFlow<List<UserCharacter>> = _characters

    // Save all stored characters from database
    fun loadSavedCharacters() {
        viewModelScope.launch {
            _characters.value = UserCharacterRepository.getUserCharacters() // <- resultatet i StateFlow
        }
    }
}
