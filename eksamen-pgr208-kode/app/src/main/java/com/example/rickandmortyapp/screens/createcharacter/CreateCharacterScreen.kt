package com.example.rickandmortyapp.screens.createcharacter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.data.dataclasses.UserCharacter

@Composable
fun CreateCharacterScreen(viewModel: CreateCharacterViewModel) {
    // State for Input-felter fra brukeren
    val characterName = remember {
        mutableStateOf("")
    }
    val characterStatus = remember {
        mutableStateOf("")
    }
    val characterSpecies = remember {
        mutableStateOf("")
    }
    val characterType = remember {
        mutableStateOf("")
    }
    val characterGender = remember {
        mutableStateOf("")
    }
    val characterOrigin = remember {
        mutableStateOf("")
    }
    val characterLocation = remember {
        mutableStateOf("")
    }
    val characterCreated = remember {
        mutableStateOf("")
    }


    val errorMessage = remember { // <-State Error-handling om feltene er tom
        mutableStateOf("")
    }

    // Oversikt for skjermen
    Column {
        Text(
            text = "Create New Character",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            fontSize = 18.sp,
            color = Color(250, 145, 70),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            // Input-felter for opprettelse av ny character
                TextField(
                    value = characterName.value,
                    onValueChange = { characterName.value = it },
                    label = { Text("Name") },
                    modifier = Modifier.padding(vertical = 8.dp)
                )

            TextField(
                value = characterStatus.value,
                onValueChange = { characterStatus.value = it },
                label = { Text("Status") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = characterSpecies.value,
                onValueChange = { characterSpecies.value = it },
                label = { Text("Species") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = characterType.value,
                onValueChange = { characterType.value = it },
                label = { Text("Type") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = characterGender.value,
                onValueChange = { characterGender.value = it },
                label = { Text("Gender") },
                modifier = Modifier.padding(vertical = 8.dp)
            )


            TextField(
                value = characterOrigin.value,
                onValueChange = { characterOrigin.value = it },
                label = { Text("Origin") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = characterLocation.value,
                onValueChange = { characterLocation.value = it },
                label = { Text("Location") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = characterCreated.value,
                onValueChange = { characterCreated.value = it },
                label = { Text("Created") },
                modifier = Modifier.padding(vertical = 8.dp)
            )

            if (errorMessage.value.isNotEmpty()) { // <- Viser feil melding til bruker om fullføringen feiler
                Text(
                    text = errorMessage.value,
                    color = Color(255, 0, 0),
                    modifier = Modifier.padding(4.dp)
                )
            }

            // Lagrer character etter utfyllelse av felter
            Button(
                onClick = {
                    when {
                        characterName.value.isBlank() -> {
                            errorMessage.value = "Name field must be filled"
                        }

                        characterStatus.value.isBlank() -> {
                            errorMessage.value = "Status field must be filled"
                        }

                        characterSpecies.value.isBlank() -> {
                            errorMessage.value = "Species field must be filled"

                        }

                        characterType.value.isBlank() -> {
                            errorMessage.value = "Type field must be filled"

                        }

                        characterGender.value.isBlank() -> {
                            errorMessage.value = "Gender field must be filled"

                        }

                        characterOrigin.value.isBlank() -> {
                            errorMessage.value = "Origin field must be filled"

                        }

                        characterLocation.value.isBlank() -> {
                            errorMessage.value = "Location field must be filled"

                        }

                        characterCreated.value.isBlank() -> {
                            errorMessage.value = "Created field must be filled"

                        }

                        // Gjentar
                        else -> {
                            val newCharacter = UserCharacter(
                                name = characterName.value,
                                status = characterStatus.value,
                                species = characterSpecies.value,
                                type = characterType.value,
                                gender = characterGender.value,
                                origin = characterOrigin.value,
                                location = characterLocation.value,
                                created = characterCreated.value
                            )
                            viewModel.saveCharacter(newCharacter)
                            // tilbastiller igjen feltene
                            characterName.value = ""
                            characterStatus.value = ""
                            characterSpecies.value = ""
                            characterType.value = ""
                            characterGender.value = ""
                            characterOrigin.value = ""
                            characterLocation.value = ""
                            characterCreated.value = ""
                            errorMessage.value = ""
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0, 200, 0),
                    contentColor = Color(255, 255, 255)
                )
            ) {
                Text(
                    text = "Save Character",
                    fontWeight = FontWeight.Bold,
                )

            }
        }
    }
}
