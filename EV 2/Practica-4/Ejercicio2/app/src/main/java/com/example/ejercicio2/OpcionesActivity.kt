package com.example.ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class OpcionesActivity : AppCompatActivity() {

    private lateinit var textViewNote: TextView // Campo de texto para mostrar la nota  
    private lateinit var buttonShare: Button // Botón para compartir la nota  
    private lateinit var buttonEdit: Button // Botón para editar la nota  
    private var noteText = "" // Variable para almacenar el texto de la nota  

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones) // Establecer la interfaz de usuario para esta actividad  

        // Inicializar las vistas  
        textViewNote = findViewById(R.id.textViewNote)
        buttonShare = findViewById(R.id.buttonShare)
        buttonEdit = findViewById(R.id.buttonEdit)

        // Recuperar el texto de la nota del intent o del estado guardado  
        if (savedInstanceState != null) {
            noteText = savedInstanceState.getString("noteText", "")
        } else {
            // Obtener el texto de la nota desde el intent que inicia esta actividad  
            noteText = intent.getStringExtra("nota") ?: ""
        }

        // Mostrar la nota en el TextView  
        textViewNote.text = noteText

        // Configurar el botón para compartir la nota por correo  
        buttonShare.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show() // Mensaje de confirmación  
        }

        // Configurar el botón para volver a editar la nota  
        buttonEdit.setOnClickListener {
            // Preparar el resultado para devolver a la actividad anterior  
            val resultIntent = Intent()
            resultIntent.putExtra("nota_editada", noteText) // Pasar el texto de la nota editada  
            setResult(RESULT_OK, resultIntent) // Establecer el resultado  
            finish() // Cerrar esta actividad y volver a la anterior  
        }
    }

    // Guardar el estado de la actividad antes de ser destruida (por ejemplo, al rotar la pantalla)  
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("noteText", noteText) // Guardar el texto de la nota  
    }
}  