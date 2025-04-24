
package com.example.configuradorpedidos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

// Actividad principal que contiene el NavHost para la navegación entre fragmentos.  
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el layout de la actividad.  
    }

    // Inicializa el NavHostFragment y el NavController para la navegación.  
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
}  