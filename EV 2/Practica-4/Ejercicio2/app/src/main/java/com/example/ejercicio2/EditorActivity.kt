package com.example.ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class EditorActivity : AppCompatActivity() {

    private lateinit var editTextNote: EditText // Campo de texto para la nota  
    private lateinit var buttonShare: Button // Botón para compartir la nota  
    private var noteText = "" // Variable para almacenar el texto de la nota  

    // Registro del callback para recibir resultados de la actividad OpcionesActivity  
    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Verificar si se recibió un resultado exitoso  
        if (result.resultCode == RESULT_OK) {
            // Recuperar el texto de la nota que fue devuelto desde OpcionesActivity  
            val receivedNote = result.data?.getStringExtra("nota_editada") ?: ""
            editTextNote.setText(receivedNote) // Establecer el texto en el campo  
            // Posicionar el cursor al final del texto para facilitar la edición  
            editTextNote.setSelection(receivedNote.length)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor) // Establecer la interfaz de usuario para esta actividad  

        // Inicializar las vistas  
        editTextNote = findViewById(R.id.editTextNote)
        buttonShare = findViewById(R.id.buttonShare)

        // Restaurar el texto de la nota si hay un estado guardado  
        if (savedInstanceState != null) {
            noteText = savedInstanceState.getString("noteText", "")
            editTextNote.setText(noteText) // Establecer el texto recuperado en el campo  
        }

        // Configurar el botón de compartir  
        buttonShare.setOnClickListener {
            // Obtener el texto de la nota desde el campo  
            noteText = editTextNote.text.toString()

            // Crear un intent para iniciar la actividad OpcionesActivity  
            val intent = Intent(this, OpcionesActivity::class.java)
            intent.putExtra("nota", noteText) // Pasar el texto de la nota a la nueva actividad  

            // Iniciar la actividad esperando un resultado  
            getResult.launch(intent)
        }
    }

    // Guardar el estado de la actividad antes de ser destruida (por ejemplo, al rotar la pantalla)  
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("noteText", editTextNote.text.toString()) // Guardar el texto de la nota  
    }
}  