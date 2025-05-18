package com.example.juegodcolores
import android.content.Context
import androidx.core.content.ContextCompat

class ColorManager(private val context: Context) {

    // Lista de colores utilizados en el juego
    val colorMap = mapOf(
        R.color.pink to R.string.pink,
        R.color.cyan to R.string.cyan,
        R.color.magenta to R.string.magenta,
        R.color.lime to R.string.lime,
        R.color.brown to R.string.brown,
        R.color.teal to R.string.teal
    )

    // Mapeo de botones con sus colores correspondientes
    val buttonColorMap = mapOf(
        R.id.pinkButton to R.color.pink,
        R.id.cyanButton to R.color.cyan,
        R.id.magentaButton to R.color.magenta,
        R.id.limeButton to R.color.lime,
        R.id.brownButton to R.color.brown,
        R.id.tealButton to R.color.teal
    )

    // Color activo que se muestra en pantalla
    var currentColor = R.color.pink

    // Función para seleccionar un color al azar
    fun getRandomColor(): Int {
        val colors = colorMap.keys.toList()
        val randomIndex = (0 until colors.size).random()
        return colors[randomIndex]
    }

    // Función para obtener el nombre del color en texto
    fun getColorName(colorResId: Int): String {
        val stringResId = colorMap[colorResId] ?: R.string.pink
        return context.getString(stringResId)
    }

    // Función para obtener el valor del color en formato Android
    fun getColorValue(colorResId: Int): Int {
        return ContextCompat.getColor(context, colorResId)
    }
}