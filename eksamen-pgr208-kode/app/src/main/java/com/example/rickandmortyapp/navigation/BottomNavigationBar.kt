package com.example.rickandmortyapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController



@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    selectedTabIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    // Justerer fargene i navigasjonsmenyen
    val itemColors = NavigationBarItemDefaults.colors(
        indicatorColor = Color(30, 30, 30),
        selectedIconColor = Color(250, 145, 70),
        selectedTextColor = Color(250, 145, 70),
        unselectedIconColor = Color(150, 100, 30),
        unselectedTextColor = Color(150, 100, 30)
    )

    // Navigasjonsmeny for å bytte mellom skjermene
    NavigationBar(
        containerColor = Color(0, 0, 0)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Characters") },
            label = { Text("Characters") },
            selected = selectedTabIndex == 0,
            onClick = {
                // Kilde: https://developer.android.com/develop/ui/compose/navigation#bottom-nav
                onItemSelected(0)
                navController.navigate("character_list") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            colors = itemColors
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Saved") },
            label = { Text("Saved") },
            selected = selectedTabIndex == 1,
            onClick = {
                onItemSelected(1)
                navController.navigate("saved_characters") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            colors = itemColors
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Create, contentDescription = "Create") },
            label = { Text("Create") },
            selected = selectedTabIndex == 2,
            onClick = {
                onItemSelected(2)
                navController.navigate("create_character") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            colors = itemColors
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Refresh, contentDescription = "Random") },
            label = { Text("Random") },
            selected = selectedTabIndex == 3,
            onClick = {
                onItemSelected(3)
                navController.navigate("random_character") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            colors = itemColors
        )
    }
}










