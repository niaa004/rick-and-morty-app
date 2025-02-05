## Introduction
This is Android application which fetches data from the Rick and Morty API.  

## Technologies & Frameworks
Language: Kotlin
UI: Jetpack Compose
Architecture: MVVM (Model-View-ViewModel)
Data Handling: Room Database (Local Storage)
API Integration: Retrofit (Network Requests)
API Documentation & Testing: Swagger / OpenAPI
State Management: ViewModel & LiveData

## Project Structure
``` 
📦 com.example.rickandmortyapp
├── 📂 components          # Reusable UI components
│   ├── CharacterItem.kt
│   ├── UserCharacterItem.kt
│
├── 📂 data                # Handles data operations
│   ├── 📂 dataclasses     # Data models for API & database objects
│   │   ├── Character.kt
│   │   ├── CharacterList.kt
│   │   ├── UserCharacter.kt
│   │
│   ├── 📂 retrofit        # Retrofit classes for API integration
│   │   ├── CharacterRepository.kt
│   │   ├── CharacterService.kt
│   │
│   ├── 📂 room            # Room Database classes & DAO
│       ├── RickAndMortyDatabase.kt
│       ├── UserCharacterDao.kt
│       ├── UserCharacterRepository.kt
│
├── 📂 navigation          # Navigation logic
│   ├── BottomNavigationBar.kt
│   ├── ScreenNavigation.kt
│
├── 📂 screens             # Main screens of the application
│
├── 📂 ui/theme            # Theming and styles for the app
│
├── MainActivity.kt        # Entry point of the application
``` 

- Character List Screen
Fetches and displays a list of characters from the API.
Implements pagination for smooth navigation between pages.

- Create Character Screen
Allows users to create custom characters.
Built-in validation to ensure valid input.
Saves data in a local Room Database.

- Saved Characters Screen
Displays a list of user-created characters.
Data is retrieved from the local database.

- Random Character Screen
Generates a random character from the API.
Implements caching for faster loading.
