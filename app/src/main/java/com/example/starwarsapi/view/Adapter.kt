package com.example.starwarsapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapi.R
import com.example.starwarsapi.model.StarWarsModel
import kotlinx.android.synthetic.main.fragment_card_view.view.*

class Adapter(var starWarsModel: StarWarsModel): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_card_view, parent, false))
    }

    override fun getItemCount(): Int {
        return starWarsModel.results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = starWarsModel.results[position].name

        var height_in_cm = starWarsModel.results[position].height
        var height_in_feet = height_in_cm * 0.0328084
        holder.tv_height.text = height_in_feet.toString()
    }
}