package com.example.pantallas.Screen


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pantallas.viewmodel.PersonaViewModel


@Preview(showBackground = true)
@Composable
fun navigationExample() {
    val navController = rememberNavController()
    val personaViewModel: PersonaViewModel = viewModel()

    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController, personaViewModel)
        }
        composable("screen_b") {
            ScreenB(navController, personaViewModel)
        }
    }
}

