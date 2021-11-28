package com.example.s205435lykkehjulet

enum class CategoryWords(val nameOfCategory: String, val listOf: List<String>) {
    BILMAERKER("Bilmærker",listOf("Audi", "Mercedes", "Bmw", "Kia")),
    MAD("Mad",listOf("Lasagne", "Pizza", "Sandwich", "Ananas")),
    COMPUTERSPIL("Computer spil",listOf("Battlefield", "Fifa", "Fortnite","Minecraft"))
}