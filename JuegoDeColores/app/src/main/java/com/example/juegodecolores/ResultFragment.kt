package com.example.juegodecolores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment(R.layout.fragment_result) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val score = arguments?.getInt("score") ?: 0
        val message = when {
            score >= 20 -> "¡Increíble!"
            score >= 10 -> "¡Bien hecho!"
            else -> "¡Sigue practicando!"
        }
        val prefs = requireContext().getSharedPreferences("color_game", Context.MODE_PRIVATE)
        val best = prefs.getInt("high_score", 0)

        if (score > best) {
            prefs.edit().putInt("high_score", score).apply()
        }

        view.findViewById<TextView>(R.id.scoreText).text = "Puntaje: $score\nMáximo: $best\n$message"


        view.findViewById<TextView>(R.id.scoreText).text = "Puntaje: $score\n$message"

        view.findViewById<Button>(R.id.btnRestart).setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }
}
