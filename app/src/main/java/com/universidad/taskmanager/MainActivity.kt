package com.universidad.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.universidad.taskmanager.ui.MainActivity

// Esta clase ahora solo redirige a la verdadera MainActivity en el paquete UI para cumplir con la estructura del profesor
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Redirigir a la MainActivity real
        val intent = android.content.Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
