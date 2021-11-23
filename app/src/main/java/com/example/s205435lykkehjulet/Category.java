package com.example.s205435lykkehjulet;

public class Category {
    private String name;
    private String[] words;

    public Category(String name, String[] words)
    {
        this.name = name;
        this.words = words;
    }

    public String getRandomWord()
    {
        int range = words.length;
        int randomInt = (int) (Math.random() * (range - 0) + 0);
        String randomWord = words[randomInt];
        return randomWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
