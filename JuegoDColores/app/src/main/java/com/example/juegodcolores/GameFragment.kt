package com.example.juegodcolores

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.juegodcolores.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    // Instancia del gestor de colores
    private lateinit var colorManager: ColorManager

    // Variables para el puntaje y temporizador
    private var score = 0
    private var gameTime = 30000L // 30 segundos en milisegundos
    private var timeRemaining = gameTime
    private lateinit var countDownTimer: CountDownTimer
    private var gameRunning = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Creamos la instancia del gestor de colores
        colorManager = ColorManager(requireContext())

        // Configuración de los listeners para los botones de colores
        setupButtonListeners()

        // Se inicia la partida
        startGame()
    }

    private fun setupButtonListeners() {
        // Para cada botón, asignamos su acción
        for ((buttonId, colorId) in colorManager.buttonColorMap) {
            view?.findViewById<Button>(buttonId)?.setOnClickListener {
                // Verificamos la respuesta seleccionada
                checkAnswer(colorId)

                // Añadimos animate al botón pulsado
                val pulseAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse_animation)
                it.startAnimation(pulseAnimation)
            }
        }
    }

    private fun startGame() {
        // Limpiamos puntuación y refrescamos contador
        score = 0
        timeRemaining = gameTime
        updateScoreDisplay()

        // Mostramos el primer color
        setNewRandomColor()

        // Arrancamos la cuenta regresiva
        startTimer()

        // Indicamos que el tiempo de juego está activo
        gameRunning = true
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeRemaining, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualizamos el conteo restante
                timeRemaining = millisUntilFinished
                val secondsRemaining = millisUntilFinished / 1000
                binding.timerTextView.text = getString(R.string.time_remaining, secondsRemaining)
            }

            override fun onFinish() {
                // Cuando se acaba el tiempo, termina la partida
                endGame()
            }
        }.start()
    }

    private fun checkAnswer(selectedColorId: Int) {
        if (!gameRunning) return

        if (selectedColorId == colorManager.currentColor) {
            // Respuesta correcta, sumamos puntos
            score++
            updateScoreDisplay()

            // Se muestra un nuevo color
            setNewRandomColor()
        } else {
            // Respuesta incorrecta - Sin puntuación adicional
            // Opcional: feedback visual o de audio
        }
    }

    private fun setNewRandomColor() {
        // Escogemos un nuevo color de forma aleatoria
        colorManager.currentColor = colorManager.getRandomColor()

        // Aplicamos el color al fondo del display
        binding.colorDisplay.setBackgroundColor(colorManager.getColorValue(colorManager.currentColor))

        // Animamos el cambio de color
        val fadeAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.colorDisplay.startAnimation(fadeAnimation)
    }

    private fun updateScoreDisplay() {
        // Se actualiza la puntuación mostrada
        binding.scoreTextView.text = getString(R.string.score, score)
    }

    private fun endGame() {
        // Cerramos el temporizador, si aún corre
        if (::countDownTimer.isInitialized) {
            countDownTimer.cancel()
        }

        // Indicamos que la partida terminó
        gameRunning = false

        // Navegamos hacia la pantalla de resultados, enviando la puntuación
        val action = GameFragmentDirections.actionGameFragmentToResultFragment(score)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Si hay temporizador activo, se detiene al salir del fragmento
        if (::countDownTimer.isInitialized) {
            countDownTimer.cancel()
        }

        _binding = null
    }
}