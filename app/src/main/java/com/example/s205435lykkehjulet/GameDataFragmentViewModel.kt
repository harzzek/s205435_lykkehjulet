package com.example.s205435lykkehjulet

import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

class GameDataFragmentViewModel : ViewModel() {
    val player: Player = Player()
    val category: Category = chooseRanCategory()
    val word: String = category.getRandomWord()
    var hiddenWord = hideWord()
    var wheelspinValue: String? = null
    val guessedLetters = mutableSetOf<Char>()

    fun chooseRanCategory(): Category {
        val chosen = CategoryWords.values().random()
        return Category(chosen.name, chosen.listOf)
    }

    fun chooseCategory(category: String): Category
    {
        val chosen = CategoryWords.valueOf(category)
        return Category(chosen.name, chosen.listOf)
    }

    fun hideWord() : String
    {
        val builder = StringBuilder()

        for (letter in word.indices)
        {
            builder.append('*')
        }
        return builder.toString()
    }

    fun showLetter(input : Char) : Boolean
    {
        if(word.contains(input, ignoreCase = true))
        {
            val newHidden = StringBuilder()
            guessedLetters.add(input)
            for(i in word.indices)
            {
                if(!hiddenWord.get(i).equals('*'))
                {
                    newHidden.append(hiddenWord.get(i))
                } else if (!word.get(i).equals(input, ignoreCase = true))
                {
                    newHidden.append('*')
                } else newHidden.append(input)
            }
            hiddenWord = newHidden.toString()
            return true
        } else
        {
            guessedLetters.add(input)
            return false
        }
    }
}