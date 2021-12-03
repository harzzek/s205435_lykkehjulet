package com.example.s205435lykkehjulet

/**
 * Basic player class with life and score
 */
class Player(var playerLife: Int = 5, var playerScore: Int = 0) {

    /**
     * Player looses life if function is called
     */
    fun loseLife()
    {
        playerLife--
    }

    /**
     * Gain an score equal to parameter input
     */
    fun gainScore(score: Int)
    {
        playerScore += score
    }
}