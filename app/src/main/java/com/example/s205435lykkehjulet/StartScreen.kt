package com.example.s205435lykkehjulet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.absoluteValue

/**
 * Startscreen Fragment.
 * Contains a button and textview, that's all. Does not bear function
 */
class StartScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_screen, container, false)



        val myFab: Button = view.findViewById(R.id.startbutton)
        myFab.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_startScreen_to_categoryList)}
        return view
    }

    override fun onStart() {
        super.onStart()
    }
}