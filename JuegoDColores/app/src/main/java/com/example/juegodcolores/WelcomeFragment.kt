package com.example.juegodcolores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.juegodcolores.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Animamos el título y la imagen de bienvenida
        val fadeInAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.welcomeTitle.startAnimation(fadeInAnimation)
        binding.welcomeImage.startAnimation(fadeInAnimation)

        // Configuración del botón para comenzar a jugar
        binding.startGameButton.setOnClickListener {
            // Se realiza una animación al pulsar
            val pulseAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse_animation)
            it.startAnimation(pulseAnim)

            // Se navega hacia la pantalla del juego
            findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}