package com.example.simonnodice

import android.util.Log
import com.example.simonnodice.ui.theme.SimonNoDiceTheme
import com.example.simonnodice.Botones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent



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

