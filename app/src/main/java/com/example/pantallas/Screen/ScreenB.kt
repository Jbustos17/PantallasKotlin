package com.example.pantallas.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pantallas.viewmodel.PersonaViewModel

@Composable
fun ScreenB(navController: NavController, personaViewModel: PersonaViewModel = viewModel()) {
    val listaPersonas by personaViewModel.personas.collectAsState()
    val azulClaro = Color(0xFF336699)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Lista de personas",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(listaPersonas) { persona ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = azulClaro)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nombre: ${persona.nombre}", color = Color.White)
                        Text("Correo: ${persona.correo}", color = Color.White)
                        Text("Profesión: ${persona.profesion}", color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = azulClaro),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Volver a pantalla A", color = Color.White)
        }
    }
}
