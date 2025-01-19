package com.example.rickandmortyapp.data.retrofit

import android.util.Log
import com.example.rickandmortyapp.data.dataclasses.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterRepository {

    // Logger http-kall for debugging
    private val _okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).build()

    // Oppretter Retrofit-instans for APIet
    private val _retrofit = Retrofit.Builder()
        .client(_okHttpClient)
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    // Definerer API-tjenesten
    private val _characterService = _retrofit.create(
        CharacterService::class.java)

    // Henter characters fra APIet basert på side
    suspend fun loadAllCharacters(page: Int): List<Character> {
        try {
            val response = _characterService.loadAllCharacters(page)

            if (response.isSuccessful) {
                return response.body()?.results ?: emptyList()
            } else {
                return emptyList()
            }

        } catch (e: Exception) {  // <- Error-logging
            Log.e("CharacterRepository", "Error catching characters by Page $page", e)
            return emptyList()
        }
    }

    // Henter en character basert på ID
    suspend fun loadCharacterById(id: Int): Character? {
        return try {
            val response = _characterService.loadCharacterById(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {  // <- Error-logging
            Log.e("CharacterRepository", "Error catching character by ID: $id", e)
            null
        }
    }
}

