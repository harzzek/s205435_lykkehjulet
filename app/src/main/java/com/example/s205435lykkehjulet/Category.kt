package com.example.s205435lykkehjulet

class Category(val name: String, val words : List<String>)
{

    fun getRandomWord(): String {
        return words.random()
    }
}