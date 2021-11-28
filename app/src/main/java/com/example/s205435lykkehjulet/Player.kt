package com.example.s205435lykkehjulet

class Player(var playerLife: Int = 5, var playerScore: Int = 0) {

    fun loseLife()
    {
        playerLife--
    }

    fun gainScore(score: Int)
    {
        playerScore += score
    }
}