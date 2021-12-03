package com.example.s205435lykkehjulet
/**
* Logical class containing the category with name and words to guess from category
* */
class Category(var name: String, val words : List<String>)
{

    /**
     * Random word parser. Chooses which word to guess
     */
    fun getRandomWord(): String {
        return words.random()
    }
}