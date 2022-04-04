package com.example.recyclerview_search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var mYimage: ImageView? = null
    private var followers_num: TextView? = null
    private var exPrience: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.name)
        mYearView = itemView.findViewById(R.id.location)
        mYimage = itemView.findViewById(R.id.image)
        followers_num = itemView.findViewById(R.id.followers)
        exPrience = itemView.findViewById(R.id.experience)

    }
    fun bind(movie: Movie) {
        mTitleView?.text = movie.name
        mYearView?.text = movie.location_city
        mYimage?.setImageResource(movie.Image)
        followers_num?.text = movie.numberFollowers.toString()
        exPrience?.text = movie.Exprience


    }
}

