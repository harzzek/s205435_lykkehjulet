package com.example.s205435lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.s205435lykkehjulet.databinding.FragmentCategoryListBinding

class CategoryList : Fragment() {
    // TODO: Rename and change types of parameters
    val categories: Array<Category>? = null
    var _binding: FragmentCategoryListBinding? = null
    val binding get() = _binding!!

    fun createCategoryItems()
    {
        val categoriesEnum: Array<CategoryWords> = CategoryWords.values()
        for (item in categoriesEnum)
        {
            val i = 0
            categories?.set(i, Category(categoriesEnum[i].name, categoriesEnum[i].listOf))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryListBinding.inflate(inflater,container,false)
        val view = binding.root

        createCategoryItems()
        // Inflate the layout for this fragment
        return view
    }
}