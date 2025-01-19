# Rick and Morty App

## 📌 Introduksjon
Denne applikasjonen er en Android-app utviklet i **Kotlin**, som henter data fra **Rick and Morty API**.
Prosjektet er bygget med **Jetpack Compose, Room Database og Retrofit**, og følger **MVVM-arkitektur** for å sikre skalerbarhet og god separasjon av ansvar.

---

## 🛠 Teknologier og rammeverk
- **Språk:** Kotlin
- **UI:** Jetpack Compose
- **Arkitektur:** MVVM (Model-View-ViewModel)
- **Databehandling:** Room Database
- **API-integrasjon:** Retrofit
- **State management:** ViewModel & LiveData
- **Bildehåndtering:** Coil
- **Navigasjon:** Navigation Component

---

## 📂 Prosjektstruktur
Applikasjonen er organisert i logiske pakker for å sikre modularitet og vedlikeholdbarhet:

\`\`\`
📦 com.example.rickandmortyapp
 ┣ 📂 components          # Gjenbrukbare UI-komponenter
 ┣ 📂 data
 ┃ ┣ 📂 dataclasses       # Datamodeller for API- og databaseobjekter
 ┃ ┣ 📂 retrofit          # Retrofit-klasser for API-integrasjon
 ┃ ┣ 📂 room              # Room Database-klasser og DAO
 ┣ 📂 navigation          # Navigasjonslogikk
 ┣ 📂 screens             # Hovedskjermer i applikasjonen
 ┣ 📂 viewmodels          # ViewModel-klasser for databehandling
\`\`\`

---

## 📌 Funksjonalitet
### **1️⃣ Karakterliste (Character List Screen)**
- Henter og viser en liste med karakterer fra API-et.
- Implementert paginering for smidig navigering mellom sider.

### **2️⃣ Opprett karakter (Create Character Screen)**
- Lar brukeren opprette egendefinerte karakterer.
- Innebygget validering for å sikre gyldig input.
- Data lagres i en lokal Room Database.

### **3️⃣ Lagrede karakterer (Saved Characters Screen)**
- Viser en liste over karakterer som brukeren har opprettet.
- Data hentes fra lokal database.

### **4️⃣ Tilfeldig karakter (Random Character Screen)**
- Genererer en tilfeldig karakter fra API-et.
- Implementert caching for raskere lasting.

---

## 🛠 Implementasjonsdetaljer
- **MVVM-arkitektur** sikrer at UI-komponenter kun håndterer visning, mens ViewModels håndterer dataflyt og logikk.
- **Retrofit** brukes for API-kall, med en egen repository-lag for håndtering av nettverksforespørsler.
- **Room Database** sørger for at brukerens data lagres lokalt, og kan hentes opp selv uten internettforbindelse.
- **LazyColumn** brukes for effektiv rendering av store datasett i lister.

---

## 📌 Installasjon og kjøring
1️⃣ **Klon repoet:**
   \`\`\`sh
   git clone https://github.com/niaa004/rick-and-morty-app.git
   cd rick-and-morty-app
   \`\`\`
2️⃣ **Åpne i Android Studio**
3️⃣ **Bygg og kjør appen på en emulator eller fysisk enhet**

---

## 📈 Videre utvikling
Potensielle forbedringer inkluderer:
✅ **Implementere et søkefelt** for å filtrere karakterer basert på navn.
✅ **Forbedre UI/UX** med mer sofistikerte animasjoner.
✅ **Legge til caching av API-respons** for bedre ytelse.
✅ **Forbedret feil- og nettverkshåndtering** for bedre brukeropplevelse.

---

## 📜 Lisens og kilder
MIT License © Nicolai Aalberg
- Data er hentet fra [Rick and Morty API](https://rickandmortyapi.com/documentation).

---

## 💡 Oppsummering
Dette prosjektet demonstrerer **moderne Android-utvikling** med **Jetpack Compose, Room og Retrofit**.
Koden er strukturert for skalerbarhet, og implementasjonen av **MVVM-arkitektur** sikrer god separasjon av ansvar.

Dette er et **praktisk eksempel på API-integrasjon og lokal datalagring**, og kan videreutvikles med nye funksjoner og optimaliseringer.

✅ **Dersom du ønsker å se mer av koden eller bidra, besøk GitHub-repoet!**

---
