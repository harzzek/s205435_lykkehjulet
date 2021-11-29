package com.example.s205435lykkehjulet

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.s205435lykkehjulet.databinding.FragmentCategoryListBinding
import java.util.*
import kotlin.collections.ArrayList

class CategoryList : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var gameData : GameDataFragmentViewModel
    var _binding: FragmentCategoryListBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryListBinding.inflate(inflater,container,false)
        val view = binding.root

        gameData = ViewModelProvider(this).get(GameDataFragmentViewModel::class.java)

        val categoryAdapter = CategoryAdapter(categoriesToList(), gameData)
        binding.categoryRec.adapter = categoryAdapter

        // Inflate the layout for this fragment
        return view
    }

    fun categoriesToList() : List<String>
    {
        val listOfCategories = mutableListOf<String>()
        var counter = 0
        for (item in CategoryWords.values())
        {
            listOfCategories.add(CategoryWords.values().get(counter).nameOfCategory)
            counter++
        }

        return listOfCategories
    }

}