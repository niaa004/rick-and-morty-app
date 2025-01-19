package com.example.rickandmortyapp.screens.randomcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.Character
import com.example.rickandmortyapp.data.retrofit.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel for å hente tilfeldige characters fra APIet
class RandomCharacterViewModel : ViewModel() {
    private val _randomCharacter = MutableStateFlow<Character?>(null)
    val randomCharacter = _randomCharacter.asStateFlow()

    // Genererer tilfeldig ID innenfor character i APIet
    private fun getRandomCharacterId(min: Int = 1, max: Int = 826): Int {
        return (min..max).random()
    }

    // Genererer tilfeldig character basert på ID
    fun loadRandomCharacter() {
        viewModelScope.launch {
            val randomId = getRandomCharacterId()
            val character = CharacterRepository.loadCharacterById(randomId)
            _randomCharacter.value = character // // <- StateFlow oppdateres
        }
    }
    }
