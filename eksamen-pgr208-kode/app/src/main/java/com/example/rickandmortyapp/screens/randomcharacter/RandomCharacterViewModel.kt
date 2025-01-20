package com.example.rickandmortyapp.screens.randomcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.Character
import com.example.rickandmortyapp.data.retrofit.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel get random characters from API
class RandomCharacterViewModel : ViewModel() {
    private val _randomCharacter = MutableStateFlow<Character?>(null)
    val randomCharacter = _randomCharacter.asStateFlow()

    // Genererer random ID by characters in API
    private fun getRandomCharacterId(min: Int = 1, max: Int = 826): Int {
        return (min..max).random()
    }

    // Generates random characters sorted by ID
    fun loadRandomCharacter() {
        viewModelScope.launch {
            val randomId = getRandomCharacterId()
            val character = CharacterRepository.loadCharacterById(randomId)
            _randomCharacter.value = character // // <- StateFlow oppdateres
        }
    }
    }
