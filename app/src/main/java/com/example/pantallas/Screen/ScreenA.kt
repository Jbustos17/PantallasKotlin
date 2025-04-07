package com.example.pantallas.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pantallas.R
import com.example.pantallas.Modelo.Persona
import com.example.pantallas.viewmodel.PersonaViewModel

@Composable
fun ScreenA(navController: NavController, viewModel: PersonaViewModel) {
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var correo by remember { mutableStateOf(TextFieldValue("")) }
    var profesion by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Uniminuto",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )


            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") }
            )

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") }
            )

            OutlinedTextField(
                value = profesion,
                onValueChange = { profesion = it },
                label = { Text("Profesión") }
            )


            Button(
                onClick = {
                    val persona = Persona(
                        nombre = nombre.text,
                        correo = correo.text,
                        profesion = profesion.text
                    )
                    viewModel.agregarPersona(persona)
                    navController.navigate("screen_b")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004A93))
            ) {
                Text("Enviar", color = Color.White)
            }
        }
    }
}
