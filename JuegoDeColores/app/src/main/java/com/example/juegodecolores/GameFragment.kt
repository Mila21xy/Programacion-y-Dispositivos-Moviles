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
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment(R.layout.fragment_game) {
    private lateinit var colorBox: TextView
    private lateinit var scoreText: TextView
    private lateinit var timerText: TextView
    private var score = 0
    private var correctColor = ""

    private lateinit var timer: CountDownTimer

    private val colors = listOf("Rojo", "Verde", "Azul", "Amarillo")
    private val colorMap = mapOf(
        "Rojo" to Color.RED,
        "Verde" to Color.GREEN,
        "Azul" to Color.BLUE,
        "Amarillo" to Color.YELLOW
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        colorBox = view.findViewById(R.id.colorBox)
        scoreText = view.findViewById(R.id.scoreText)
        timerText = view.findViewById(R.id.timerText)

        startGame(view)

        listOf("Rojo", "Verde", "Azul", "Amarillo").forEach { color ->
            view.findViewById<Button>(resources.getIdentifier("btn$color", "id", requireContext().packageName)).setOnClickListener {
                checkAnswer(color)
            }
        }
    }

    private fun startGame(view: View) {
        score = 0
        scoreText.text = "Puntaje: 0"
        showRandomColor()

        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = "Tiempo: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(score)
                findNavController().navigate(action)
            }
        }.start()
    }

    private fun showRandomColor() {
        correctColor = colors.random()
        colorBox.setBackgroundColor(colorMap[correctColor]!!)
    }

    private fun checkAnswer(selected: String) {
        if (selected == correctColor) {
            score++
            scoreText.text = "Puntaje: $score"
            // Opcional: sonido o animación
        }
        showRandomColor()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}
