package com.example.simonnodice

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class MyViewModel : ViewModel() {
    companion object {

        val contador = mutableStateOf(0)

        fun mostrarContador(): String {
            return contador.value.toString()
        }

        fun incrementarContador() {
            contador.value++
        }

    }

    fun guardarCadena(cadea :String) {
        var cadena by mutableStateOf(cadea)
    }





}
