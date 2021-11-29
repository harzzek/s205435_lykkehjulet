package com.example.s205435lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isEmpty
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.s205435lykkehjulet.databinding.FragmentFortuneWheelBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException

class FortuneWheel : Fragment() {

    private var _binding: FragmentFortuneWheelBinding? = null
    private val binding get() = _binding!!
    private var state:States = States.SPIN

    enum class States
    {
        SPIN,
        GUESS
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFortuneWheelBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.hiddenWord.text = gameData.hiddenWord
        binding.category.text = gameData.category.name
        binding.guessField.isEnabled = false
        binding.score.text = "Score: 0"
        binding.lives.text = "Lives: ${gameData.player.playerLife}"

        binding.button.setOnClickListener()
        {
            gameOver(view)
            clickButton()
        }
        return view
    }

    private fun clickButton()
    {
        if(state == States.SPIN)
        {
            spinState()
        } else if(state == States.GUESS)
        {
            if(!binding.guessField.editText?.text.isNullOrEmpty())
            {
                guessState()
            } else
            {
                Snackbar.make(binding.root,"Write something?..", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun spinState()
    {
        binding.guessField.isEnabled = true
        binding.button.text = "Guess!"
        state = States.GUESS
        gameData.wheelspinValue = Wheel.randomValue()
        binding.wheelResult.text = gameData.wheelspinValue.toString()
    }

    private fun guessState() {
        val guess = binding.guessLetter.text?.get(0)
        val boo : Boolean = gameData.showLetter(guess!!)
        if(boo)
        {
            binding.hiddenWord.text = gameData.hiddenWord
            try {
                gameData.player.gainScore(gameData.wheelspinValue!!.toInt())
            } catch (e: NumberFormatException)
            {
                println("NumberFormatExe: Compile failure")
            }
            binding.score.text = "Score: ${gameData.player.playerScore}"
        } else
        {
            gameData.player.loseLife()
            binding.lives.text = "Lives: ${gameData.player.playerLife}"
            Snackbar.make(binding.root,"You guessed wrong :(", Snackbar.LENGTH_SHORT).show()
        }


        binding.guessField.isEnabled = false
        binding.guessLetter.setText("")
        binding.guessedLetters.text = gameData.guessedLetters.toString()
        binding.button.text = "Spin to wheel!"
        state = States.SPIN
    }

    private fun gameOver(view: ConstraintLayout): Boolean
    {
        if(gameData.player.playerLife == 0 || !gameData.hiddenWord.contains('*'))
        {
            Navigation.findNavController(view).navigate(R.id.action_fortuneWheel_to_endGame)
            return true;
        }
        return false
    }

    /* For coroutines
    private fun setNewText(input: String)
    {
        val newText = "\n$input"
        binding.wheelResult.text = newText
    }

    private suspend fun setTextOnMainThread(input: String)
    {
        withContext(Main)
        {
            setNewText(input)
        }
    }

     */



    object Wheel
    {
        val listOfValues = listOf("100", "200", "300", "400")

        fun randomValue(): String {
            return listOfValues.random()
        }
    }
}