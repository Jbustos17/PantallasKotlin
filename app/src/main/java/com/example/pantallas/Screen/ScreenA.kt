package com.example.pantallas.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pantallas.R
import com.example.pantallas.Modelo.Persona
import com.example.pantallas.viewmodel.PersonaViewModel

@Composable
fun ScreenA(navController: NavController, personaViewModel: PersonaViewModel = viewModel()) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }

    var showError by remember { mutableStateOf(false) }
    var correoError by remember { mutableStateOf(false) }

    val azulOscuro = Color(0xFF004A93)

    val validarCorreo: (String) -> Boolean = {
        it.matches(Regex("^[A-Za-z0-9+_.-]+@(gmail|hotmail)\\.com$"))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(160.dp)
                .padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
                showError = false
            },
            label = { Text("Nombre") },
            isError = showError && nombre.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )
        if (showError && nombre.isBlank()) {
            Text("* Este campo es obligatorio", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                correoError = false
            },
            label = { Text("Correo electrónico") },
            isError = correoError,
            modifier = Modifier.fillMaxWidth()
        )
        if (correoError) {
            Text("* Correo invalido, Solo Gmail o Hotmail", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = profesion,
            onValueChange = {
                profesion = it
                showError = false
            },
            label = { Text("Profesión") },
            isError = showError && profesion.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )
        if (showError && profesion.isBlank()) {
            Text("* Este campo es obligatorio", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (nombre.isBlank() || profesion.isBlank()) {
                    showError = true
                } else if (!validarCorreo(correo)) {
                    correoError = true
                } else {
                    personaViewModel.agregarPersona(Persona(nombre, correo, profesion))
                    navController.navigate("screen_b")
                    nombre = ""
                    correo = ""
                    profesion = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = azulOscuro),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { navController.navigate("screen_b") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver lista", color = Color.White)
        }
    }
}
