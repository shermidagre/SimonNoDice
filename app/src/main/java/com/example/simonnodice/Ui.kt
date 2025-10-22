package com.example.simonnodice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simonnodice.ui.theme.SimonNoDiceTheme

var contador = MyViewModel.contador


@Composable
fun Botones() {

    // Box para centrar todo el contenido en la pantalla.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Columna principal para apilar los elementos verticalmente (Cuadrícula + Start).
        Column(
            // Añadimos un pequeño espacio entre la cuadrícula y el botón Start
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = MyViewModel.mostrarContador(),
                style = MaterialTheme.typography.headlineMedium

            )

            Column {
                // Fila Superior (Azul y Rojo)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    BotonColor(color = Colores.Azul, tag = "Azul")
                    BotonColor(color = Colores.Rojo, tag = "Rojo")
                }

                Spacer(modifier = Modifier.height(10.dp)) // Espacio entre filas

                // Fila Inferior (Amarillo y Verde)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    BotonColor(color = Colores.Amarillo, tag = "Amarillo")
                    BotonColor(color = Colores.Verde, tag = "Verde")
                }
            }

            Button(
                onClick = {
                    println("${MyViewModel.incrementarContador()}")
                },
                // Hacemos el botón un poco más grande para el texto "Start"
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                // Color distinto si quieres
                colors = ButtonDefaults.buttonColors(
                    containerColor = Colores.Start
                )
            ) {
                Text("Start")
            }
        }
    }
}

private fun ButtonDefaults.buttonColors(containerColor: Colores): ButtonColors {
    TODO("Not yet implemented")
}


@Composable
fun BotonColor(color: Colores, tag: String) {
    Button(
        onClick = {
            println(tag)
        },
        modifier = Modifier.size(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text("") // Puedes dejar el texto vacío o poner una inicial si lo deseas
    }
}


@Preview(showBackground = true)
@Composable
fun SimonNoDicePrevisualizado() {
    // Es buena práctica envolver el preview con el tema
    SimonNoDiceTheme{
        Botones()
    }
}