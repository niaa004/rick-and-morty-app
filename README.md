# Rick and Morty App

## 📌 Introduction
This is an Android application developed in **Kotlin**, which fetches data from the **Rick and Morty API**.  
The project is built with **Jetpack Compose, Room Database, and Retrofit**, following the **MVVM architecture** to ensure scalability and clear separation of concerns.

---

## 🛠 Technologies & Frameworks
- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Architecture:** MVVM (Model-View-ViewModel)
- **Data Handling:** Room Database
- **API Integration:** Retrofit
- **State Management:** ViewModel & LiveData
- **Image Loading:** Coil
- **Navigation:** Navigation Component

---

## 📂 Project Structure
The app is organized into logical packages to ensure **modularity** and **maintainability**:

\`\`\`
📦 com.example.rickandmortyapp
 ┣ 📂 components          # Reusable UI components
 ┣ 📂 data
 ┃ ┣ 📂 dataclasses       # Data models for API & database objects
 ┃ ┣ 📂 retrofit          # Retrofit classes for API integration
 ┃ ┣ 📂 room              # Room Database classes & DAO
 ┣ 📂 navigation          # Navigation logic
 ┣ 📂 screens             # Main screens of the application
 ┣ 📂 viewmodels          # ViewModel classes for data handling
\`\`\`

---

## 📌 Features
### **1️⃣ Character List Screen**
- Fetches and displays a list of characters from the API.
- Implemented pagination for smooth navigation between pages.

### **2️⃣ Create Character Screen**
- Allows users to create custom characters.
- Built-in validation to ensure valid input.
- Saves data in a local Room Database.

### **3️⃣ Saved Characters Screen**
- Displays a list of user-created characters.
- Data is retrieved from the local database.

### **4️⃣ Random Character Screen**
- Generates a random character from the API.
- Implements caching for faster loading.

---

## 🛠 Implementation Details
- **MVVM architecture** ensures that UI components handle only rendering, while ViewModels manage data flow and logic.
- **Retrofit** is used for API calls, with a separate repository layer handling network requests.
- **Room Database** ensures that user data is stored locally and remains accessible offline.
- **LazyColumn** is used for efficient rendering of large datasets in lists.

---

## 📌 Installation & Setup
1️⃣ **Clone the repository:**
   \`\`\`sh
   git clone https://github.com/niaa004/rick-and-morty-app.git
   cd rick-and-morty-app
   \`\`\`

2️⃣ **Open the project in Android Studio**

3️⃣ **Build and run the app on an emulator or physical device**

---

## 📈 Future Enhancements
Possible improvements include:
✅ **Implementing a search feature** to filter characters by name.  
✅ **Enhancing UI/UX** with more sophisticated animations.  
✅ **Adding API response caching** for better performance.  
✅ **Improving error and network handling** for a better user experience.  

---

## 📜 License & References
MIT License © Nicolai Aalberg  
- Data is retrieved from [Rick and Morty API](https://rickandmortyapi.com/documentation).

---

## 💡 Summary
This project demonstrates **modern Android development** using **Jetpack Compose, Room, and Retrofit**.  
The code is structured for **scalability**, and the **MVVM architecture** ensures clear separation of concerns.  

This is a **practical example of API integration and local data storage**, and it can be further improved with new features and optimizations.

✅ **If you're interested in the code or want to contribute, check out the GitHub repository!** 🚀

---
