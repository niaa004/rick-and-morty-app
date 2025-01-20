package com.example.rickandmortyapp.data.retrofit

import com.example.rickandmortyapp.data.dataclasses.Character
import com.example.rickandmortyapp.data.dataclasses.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// API Interface for all character-data from Rick and Morty API
interface CharacterService {
    @GET("character/") // <- Chosen pages that loading up
    suspend fun loadAllCharacters(
        @Query("page") page : Int) : Response<CharacterList>


    @GET("character/{id}") // <- Specifik character based on ID
    suspend fun loadCharacterById(
        @Path("id") id: Int)
    : Response<Character>
}