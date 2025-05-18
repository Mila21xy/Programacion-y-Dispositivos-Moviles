package com.example.juegodcolores

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class ScoreManager(context: Context) {

    // Claves para gestionar las preferencias compartidas
    companion object {
        private const val PREF_NAME = "color_game_preferences"
        private const val HIGH_SCORE_KEY = "record_de_puntos"
    }

    // Acceso a las preferencias del usuario
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREF_NAME, Context.MODE_PRIVATE
    )

    // Obtener la puntuación máxima lograda hasta ahora
    fun getHighScore(): Int {
        return sharedPreferences.getInt(HIGH_SCORE_KEY, 0)
    }

    // Guardar una nueva puntuación si supera la anterior
    fun saveHighScore(score: Int): Boolean {
        val previousHighScore = getHighScore()

        // Solo actualizamos si la puntuación actual es superior
        return if (score > previousHighScore) {
            sharedPreferences.edit() { putInt(HIGH_SCORE_KEY, score) }
            true // Nuevo récord establecido
        } else {
            false // La puntuación no supera la anterior
        }
    }

    // Reiniciar la puntuación máxima a cero
    fun resetHighScore() {
        sharedPreferences.edit() { remove(HIGH_SCORE_KEY) }
    }
}