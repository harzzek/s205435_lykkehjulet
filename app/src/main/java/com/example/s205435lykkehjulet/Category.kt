package com.example.s205435lykkehjulet

class Category(var name: String, val words : List<String>)
{

    fun getRandomWord(): String {
        return words.random()
    }
}