package com.example.pantallas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pantallas.viewmodel.PersonaViewModel

@Composable
fun ScreenB(navController: NavController, personaViewModel: PersonaViewModel = viewModel()) {
    val listaPersonas by personaViewModel.personas.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Lista de personas",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(listaPersonas) { persona ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF4F80B0)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Color(0xFF002F63), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = persona.nombre.firstOrNull()?.uppercase() ?: "",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))


                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text("Nombre: ${persona.nombre}", fontSize = 18.sp, color = Color.White)
                            Text("Correo: ${persona.correo}", fontSize = 18.sp, color = Color.White)
                            Text("Profesión: ${persona.profesion}", fontSize = 18.sp, color = Color.White)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004A93)),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Volver a pantalla A", color = Color.White, fontSize = 18.sp)
        }
    }
}

