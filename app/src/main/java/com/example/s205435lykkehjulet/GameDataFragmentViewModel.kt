package com.example.s205435lykkehjulet

import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

class GameDataFragmentViewModel : ViewModel() {
    var player: Player = Player()
    var category: Category? = null
    var word: String? = null
    var hiddenWord: String? = null
    var wheelspinValue: String? = null
    val guessedLetters = mutableListOf<Char>()

    fun chooseRanCategory(): Category {
        val chosen = CategoryWords.values().random()
        return Category(chosen.name, chosen.listOf)
    }

    fun chooseCategory(category: CategoryWords)
    {
        val chosen = CategoryWords.valueOf(category.toString())
        this.category = Category(chosen.name, chosen.listOf)
        word = this.category!!.getRandomWord()
        hiddenWord = hideWord()
        player = Player()
        guessedLetters.clear()
    }

    private fun hideWord() : String
    {
        val builder = StringBuilder()

        for (letter in word!!.indices)
        {
            builder.append('*')
        }
        return builder.toString()
    }

    fun showLetter(input : Char) : Int
    {
        var occurences : Int = 0
        if(word!!.contains(input, ignoreCase = true))
        {
            val newHidden = StringBuilder()
            guessedLetters.add(input)
            for(i in word!!.indices)
            {
                if(!hiddenWord!!.get(i).equals('*')|| hiddenWord!!.get(i).equals('-'))
                {
                    newHidden.append(hiddenWord!!.get(i))
                } else if (!word!!.get(i).equals(input, ignoreCase = true))
                {
                    newHidden.append('*')
                } else
                {
                    occurences++
                    newHidden.append(input)
                }
            }
            hiddenWord = newHidden.toString()
            return occurences
        } else
        {
            guessedLetters.add(input)
            return occurences
        }
    }
}