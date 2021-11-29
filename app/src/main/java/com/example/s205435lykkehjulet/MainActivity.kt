package com.example.s205435lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var gameData : GameDataFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameData = ViewModelProvider(this).get(GameDataFragmentViewModel::class.java)

    }
}