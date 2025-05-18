package com.example.juegodcolores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.juegodcolores.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    // Recibimos los datos de la puntuación a través de los argumentos
    private val args: ResultFragmentArgs by navArgs()

    // Gestor para gestionar la puntuación máxima
    private lateinit var scoreManager: ScoreManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuramos el administrador de puntuaciones
        scoreManager = ScoreManager(requireContext())

        // Mostramos en pantalla la puntuación alcanzada
        val finalScore = args.score
        binding.finalScoreTextView.text = getString(R.string.score_final, finalScore)

        // Comprobamos si es una marca personal
        if (scoreManager.saveHighScore(finalScore)) {
            // Si se establece un nuevo récord, lo mostramos
            binding.highScoreTextView.text = getString(R.string.high_score, finalScore)
            binding.highScoreTextView.visibility = View.VISIBLE
        } else {
            // En caso contrario, mostramos la mejor puntuación hasta ahora
            val highScore = scoreManager.getHighScore()
            if (highScore > 0) {
                binding.highScoreTextView.text = getString(R.string.high_score, highScore)
                binding.highScoreTextView.visibility = View.VISIBLE
            }
        }

        // Generamos un mensaje acorde a la puntuación final
        val message = when {
            finalScore < 10 -> getString(R.string.message_bad)
            finalScore < 20 -> getString(R.string.message_good)
            else -> getString(R.string.message_great)
        }
        binding.messageTextView.text = message

        // Agregamos efectos visuales a los elementos
        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.resultTitle.startAnimation(fadeIn)
        binding.finalScoreTextView.startAnimation(fadeIn)
        binding.messageTextView.startAnimation(fadeIn)

        // Configuramos la opción para volver a jugar
        binding.playAgainButton.setOnClickListener {
            // Se anima el botón con una pulsación
            val pulseAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse_animation)
            it.startAnimation(pulseAnimation)

            // Navegamos al fragmento de juego para reiniciar
            findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
        }

        // Configuramos la opción para regresar al menú principal
        binding.backToMenuButton.setOnClickListener {
            // Se aplica la animación de pulsar al botón
            val pulseAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse_animation)
            it.startAnimation(pulseAnimation)

            // Volvemos a la pantalla de bienvenida
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}