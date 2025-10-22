package com.example.simonnodice

import android.util.Log
import com.example.simonnodice.ui.theme.SimonNoDiceTheme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimonNoDiceTheme {
                Botones()
            }
        }
    }
    override fun onStart(){super.onStart();Log.d("Estado","actualmente en onStart")}
    override fun onStop(){super.onStop();Log.d("Estado","actualmente en onStop")}
    override fun onResume(){super.onResume();Log.d("Estado","actualmente en onResume")}
    override fun onPause(){super.onPause();Log.d("Estado","actualmente en onPause")}

}

@Composable
fun Botones() {
    // Box para centrar todo el contenido en la pantalla.
    var contador by remember { mutableStateOf(0) }
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
                text = "$contador",
                style = MaterialTheme.typography.headlineMedium

            )

            Column {
                // Fila Superior (Azul y Rojo)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    BotonColor(color = Color.Blue, tag = "Azul")
                    BotonColor(color = Color.Red, tag = "Rojo")
                }

                Spacer(modifier = Modifier.height(10.dp)) // Espacio entre filas

                // Fila Inferior (Amarillo y Verde)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    BotonColor(color = Color.Yellow, tag = "Amarillo")
                    BotonColor(color = Color.Green, tag = "Verde")
                }
            }

            Button(
                onClick = {
                    contador++
                    println("$contador")
                },
                // Hacemos el botón un poco más grande para el texto "Start"
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                // Color distinto si quieres
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                )
            ) {
                Text("Start")
            }
        }
    }
}

@Composable
fun BotonColor(color: Color, tag: String) {
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
fun BotonesPrevisualizados() {
    // Es buena práctica envolver el preview con el tema
    SimonNoDiceTheme{
        Botones()
    }
}