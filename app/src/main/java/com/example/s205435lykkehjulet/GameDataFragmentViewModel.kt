package com.example.s205435lykkehjulet

import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

/**
 * ViewModel that contains the game data
 */
class GameDataFragmentViewModel : ViewModel() {
    var player: Player = Player()
    var category: Category? = null
    var word: String? = null
    var hiddenWord: String? = null
    var wheelspinValue: String? = null
    val guessedLetters = mutableListOf<Char>()

    /**
     * Chooses random category
     */
    fun chooseRanCategory(): Category {
        val chosen = CategoryWords.values().random()
        return Category(chosen.name, chosen.listOf)
    }

    /**
     * Chooses the category from CategoryWords enum
     * Will place the category as a attribute in the this viewmodel
     */
    fun chooseCategory(category: CategoryWords)
    {
        val chosen = CategoryWords.valueOf(category.toString())
        this.category = Category(chosen.name, chosen.listOf)
        word = this.category!!.getRandomWord()
        hiddenWord = hideWord()
        player = Player()
        guessedLetters.clear()
    }

    /**
     * Hides the word that the user is supposed to guess
     */
    private fun hideWord() : String
    {
        val builder = StringBuilder()

        for (letter in word!!.indices)
        {
            if(word!!.get(letter).equals('-'))
            {
                builder.append('-')
            }else builder.append('*')
        }
        return builder.toString()
    }

    /**
     * If a letter is guessed, then this function is called.
     * Creates a new string that shows letters which was guessed.
     *
     * Returns the number of occurrences of given letter.
     */
    fun showLetter(input : Char) : Int
    {
        var occurences : Int = 0
        if(word!!.contains(input, ignoreCase = true))
        {
            val newHidden = StringBuilder()
            guessedLetters.add(input)
            for(i in word!!.indices)
            {
                if(!hiddenWord!!.get(i).equals('*'))
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