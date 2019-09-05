package com.example.starwarsapi.view

import android.view.View
import androidx.core.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_card_view.view.*

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var tv_name = itemView.cv_character_name
    var tv_height = itemView.cv_character_height
}