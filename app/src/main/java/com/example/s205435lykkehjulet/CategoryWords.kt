package com.example.s205435lykkehjulet

/**
 * Enum class of the categories
 * Makes it easier to implement new categories into the game
 *
 * Just write a category as a enum. Give it a name and a list of words.
 * Then the program will create a new category(and button) automatically.
 */
enum class CategoryWords(val nameOfCategory: String, val listOf: List<String>) {
    BILMAERKER("Bilmærker",listOf("Audi", "Mercedes", "Bmw", "Kia")),
    MAD("Mad",listOf("Lasagne", "Pizza", "Sandwich", "Ananas")),
    COMPUTERSPIL("Computer spil",listOf("Battlefield", "Fifa", "Fortnite","Minecraft")),
    MUSIKKUNSTNER("Musik kunstner", listOf("Dua-Lipa", "Freddie-Mercury", "Rasmus-Seebach", "Justin-Bieber")),
    Kroppen("Kroppen", listOf("Ben", "Arme"))
}