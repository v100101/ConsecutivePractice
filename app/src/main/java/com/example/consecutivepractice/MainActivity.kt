package com.example.consecutivepractice

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.consecutivepractice.screens.HomeScreen
import com.example.consecutivepractice.screens.ListScreen
import com.example.consecutivepractice.screens.MovieDetailScreen
import com.example.consecutivepractice.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            androidx.compose.material3.Text("Фильмы")
                        },
                    )
                },
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Home, contentDescription = "home")  },
                            label = { Text("Home") },
                            selected = currentRoute == "home",
                            onClick = { navController.navigate("home") }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.List, contentDescription = "list") },
                            label = { Text("List") },
                            selected = currentRoute == "list",
                            onClick = { navController.navigate("list") }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Settings, contentDescription = "settings") },
                            label = { Text("Settings") },
                            selected = currentRoute == "settings",
                            onClick = { navController.navigate("settings") }
                        )
                    }
                }
            ) {
                NavHost(navController, startDestination = "home") {
                    composable("home") { HomeScreen() }
                    composable("list") {
                        ListScreen{movieId ->
                        navController.navigate("movie_detail/$movieId")
                        }
                    }
                    composable("movie_detail/{movieId}") {
                        val movieId = it.arguments?.getString("movieId")
                        MovieDetailScreen(movieId = movieId?.toInt() ?: 0, navController = navController)
                    }
                    composable("settings") { SettingsScreen() }
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MainActivity()
}



