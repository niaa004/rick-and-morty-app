package com.example.rickandmortyapp.data.retrofit

import com.example.rickandmortyapp.data.dataclasses.Character
import com.example.rickandmortyapp.data.dataclasses.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// API Interface for alle characterdata fra Rick and Morty API
interface CharacterService {
    @GET("character/") // <- bestemmer siden som lastes
    suspend fun loadAllCharacters(
        @Query("page") page : Int) : Response<CharacterList>


    @GET("character/{id}") // <- Spesifikk character basert på ID
    suspend fun loadCharacterById(
        @Path("id") id: Int)
    : Response<Character>
}