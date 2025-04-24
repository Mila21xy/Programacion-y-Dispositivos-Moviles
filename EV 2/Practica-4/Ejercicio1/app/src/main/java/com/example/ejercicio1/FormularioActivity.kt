package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    // Claves constantes para almacenar el estado de la actividad  
    companion object {
        private const val NOMBRE_KEY = "nombre"
        private const val EDAD_KEY = "edad"
        private const val CIUDAD_KEY = "ciudad"
        private const val CORREO_KEY = "correo"
    }

    // Registro para obtener resultados de la actividad de resumen  
    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            // Al confirmar, mostramos un mensaje y reiniciamos los campos  
            Toast.makeText(this, "El perfil se guardó correctamente", Toast.LENGTH_SHORT).show()
            limpiarCampos()
        }
        // Si se cancela, los campos permanecen con los valores actuales para que el usuario pueda editarlos  
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Inicializamos los componentes de la interfaz  
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        // Restaurar los valores de entrada si se ha guardado previamente  
        savedInstanceState?.let {
            etNombre.setText(it.getString(NOMBRE_KEY, ""))
            etEdad.setText(it.getString(EDAD_KEY, ""))
            etCiudad.setText(it.getString(CIUDAD_KEY, ""))
            etCorreo.setText(it.getString(CORREO_KEY, ""))
        }

        // Configurar la acción para el botón de continuar  
        btnContinuar.setOnClickListener {
            val usuario = Usuario(
                nombre = etNombre.text.toString(),
                edad = etEdad.text.toString().toIntOrNull() ?: 0,
                ciudad = etCiudad.text.toString(),
                correo = etCorreo.text.toString()
            )

            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)
            resumenLauncher.launch(intent)
        }
    }

    // Guardar el estado de la actividad durante cambios de configuración  
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NOMBRE_KEY, etNombre.text.toString())
        outState.putString(EDAD_KEY, etEdad.text.toString())
        outState.putString(CIUDAD_KEY, etCiudad.text.toString())
        outState.putString(CORREO_KEY, etCorreo.text.toString())
    }

    private fun limpiarCampos() {
        etNombre.text.clear()
        etEdad.text.clear()
        etCiudad.text.clear()
        etCorreo.text.clear()
    }
}  