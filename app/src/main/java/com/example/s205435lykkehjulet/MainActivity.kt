package com.example.s205435lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    /**
     * The GameDataFragmentViewModel is a ViewModel contained in a scope which
     * the fragments CAN reach. Each fragment has a attribute called:
     * private val gameData : GameDataFragmentViewModel by activityViewModels()
     * This attribute handles the game data throughout the apps navigation.
     */
    private lateinit var gameData : GameDataFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameData = ViewModelProvider(this).get(GameDataFragmentViewModel::class.java)

    }
}