package com.example.s205435lykkehjulet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.viewModels
import com.example.s205435lykkehjulet.databinding.FragmentCategoryListBinding

class CategoryAdapter(private val categorySet: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>()

{
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val button : Button

        init {
            button = view.findViewById(R.id.categoryButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        view.setOnClickListener()
        {

        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = categorySet[position]
        holder.button.setOnClickListener()
        {

        }

    }

    override fun getItemCount() = categorySet.size
}