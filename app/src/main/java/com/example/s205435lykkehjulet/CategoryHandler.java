package com.example.s205435lykkehjulet;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.s205435lykkehjulet.categorisedWords.Bilmaerker;
import com.example.s205435lykkehjulet.categorisedWords.Dyr;
import com.example.s205435lykkehjulet.categorisedWords.Mad;
import com.example.s205435lykkehjulet.categorisedWords.Slik;

import java.util.Arrays;
import java.util.Objects;

public class CategoryHandler {

    private static Category[] categories = new Category[4];

    @RequiresApi(api = Build.VERSION_CODES.N)
    public CategoryHandler()
    {
        createCategories();
    }

    // Generics er bedst til håndtering af flere kategorier, hvis nu man vil implementere flere.
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(Objects.requireNonNull(e.getEnumConstants())).map(Enum::name).toArray(String[]::new);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void createCategories()
    {
        categories[0].setName("Bilmaerker");
        categories[0].setWords(getNames(Bilmaerker.class));
        categories[1].setName("Dyr");
        categories[1].setWords(getNames(Dyr.class));
        categories[2].setName("Mad");
        categories[2].setWords(getNames(Mad.class));
        categories[3].setName("Slik");
        categories[3].setWords(getNames(Slik.class));
    }

    public static Category[] getCategories() {

        return categories;
    }


}
