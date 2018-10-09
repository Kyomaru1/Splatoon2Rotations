package com.kyostudios.splatoon2rotations

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyostudios.splatoon2rotation.Rotation

class CardAdapter(private val myDataset: Array<Rotation>): RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    var data: ArrayList<Rotation> = ArrayList()

    class MyViewHolder(private val cardView: CardView): RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_rotation, parent,false) as CardView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        data.add(myDataset[position])
    }

    override fun getItemCount(): Int {
        return data.count()
    }
}