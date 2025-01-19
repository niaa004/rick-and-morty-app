    package com.example.rickandmortyapp.data.dataclasses

    data class Character( // <- Dataclass fra APIet
        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        val origin: CharacterLocation,
        val location: CharacterLocation,
        val image: String,
        val episode: List<String>,
        val url: String,
        val created: String
    )

    data class CharacterLocation( // <- Dataclass fra APIet
        val name: String,
        val url: String
    )












