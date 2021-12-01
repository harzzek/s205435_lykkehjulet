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
    private val gameData : GameDataFragmentViewModel by activityViewModels()
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
        binding.category.text = gameData.category!!.name
        binding.guessField.isEnabled = false
        binding.score.text = "Score: 0"
        binding.lives.text = "Lives: ${gameData.player.playerLife}"

        binding.button.setOnClickListener()
        {
            clickButton(view)
        }
        return view
    }

    private fun clickButton(view: ConstraintLayout)
    {
        if(state == States.SPIN)
        {
            spinState(view)
        } else if(state == States.GUESS)
        {
            if(!binding.guessField.editText?.text.isNullOrBlank())
            {
                guessState(view)
            } else
            {
                Snackbar.make(binding.root,"Write something?..", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun spinState(view: ConstraintLayout)
    {
        gameData.wheelspinValue = Wheel.randomValue()
        binding.wheelResult.text = gameData.wheelspinValue

        if(gameData.wheelspinValue.equals("Bankrupt")){
            Snackbar.make(binding.root,"Bankrupt :(", Snackbar.LENGTH_SHORT).show()
            gameData.player.playerScore = 0
            binding.score.text = "Score: ${gameData.player.playerScore}"
            binding.wheelResult.text = gameData.wheelspinValue
        } else if(gameData.wheelspinValue.equals("Extra Turn"))
        {
            Snackbar.make(binding.root,"Extra life :)", Snackbar.LENGTH_SHORT).show()
            gameData.player.playerLife++
            binding.lives.text = "Lives: ${gameData.player.playerLife}"
            binding.wheelResult.text = gameData.wheelspinValue
        } else if(gameData.wheelspinValue.equals("Miss Turn"))
        {
            Snackbar.make(binding.root,"Auch! :(", Snackbar.LENGTH_SHORT).show()
            gameData.player.loseLife()
            binding.lives.text = "Lives: ${gameData.player.playerLife}"
            binding.wheelResult.text = gameData.wheelspinValue
            gameOver(view)
        } else
        {
            binding.guessField.isEnabled = true
            binding.button.text = "Guess!"
            state = States.GUESS
        }

    }

    private fun guessState(view: ConstraintLayout) {
        val guess = binding.guessLetter.text?.get(0)
        val boo : Int = gameData.showLetter(guess!!)
        if(boo != 0)
        {
            binding.hiddenWord.text = gameData.hiddenWord
            try {
                gameData.player.gainScore(gameData.wheelspinValue!!.toInt() * boo)
            } catch (e: NumberFormatException)
            {
                println("NumberFormatExe: Compile failure")
            }
            binding.score.text = "Score: ${gameData.player.playerScore}"
            gameOver(view)
        } else
        {
            gameData.player.loseLife()
            binding.lives.text = "Lives: ${gameData.player.playerLife}"
            Snackbar.make(binding.root,"You guessed wrong :(", Snackbar.LENGTH_SHORT).show()
            gameOver(view)
        }
        binding.guessField.isEnabled = false
        binding.guessLetter.setText("")
        binding.guessedLetters.text = gameData.guessedLetters.toString()
        binding.button.text = "Spin to wheel!"
        state = States.SPIN
    }

    private fun gameOver(view: ConstraintLayout): Boolean
    {
        if(gameData.player.playerLife <= 0 || gameData.hiddenWord.equals(gameData.word, ignoreCase = true))
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
        val listOfValues = listOf("50","100", "200", "300", "400","500","1000", "Bankrupt", "Extra Turn", "Miss Turn")

        fun randomValue(): String {
            return listOfValues.random()
        }
    }
}