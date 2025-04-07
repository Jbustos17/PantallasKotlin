package com.example.pantallas.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pantallas.Modelo.Persona
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PersonaViewModel : ViewModel() {
    private val _personas = MutableStateFlow<List<Persona>>(emptyList())
    val personas: StateFlow<List<Persona>> = _personas

    fun agregarPersona(persona: Persona) {
        _personas.value = _personas.value + persona
    }
}