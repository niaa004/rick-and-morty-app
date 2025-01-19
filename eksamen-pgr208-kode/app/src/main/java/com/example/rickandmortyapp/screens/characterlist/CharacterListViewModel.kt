package com.example.rickandmortyapp.screens.characterlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.dataclasses.Character
import com.example.rickandmortyapp.data.retrofit.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList()) // <- StateFlow listen
    val characters = _characters.asStateFlow()

    private var currentPage = 1

    // Laster characters fra APIet
    fun loadCharactersFromApi(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val charactersFromApi = CharacterRepository.loadAllCharacters(page = page)
                _characters.value = charactersFromApi
                currentPage = page

            } catch (e: Exception){ // <- Error logging
                Log.e("CharacterListViewModel", "Failed to load characters : ${e.message}", e)
            }
        }
    }

        // Laster neste side
        fun loadNextPage() {
            loadCharactersFromApi(currentPage + 1)
        }

        // Laster forrige side dersom det er en
        fun loadPreviousPage() {
            if (currentPage > 1) {
                loadCharactersFromApi(currentPage -1)
            }
        }
    }

