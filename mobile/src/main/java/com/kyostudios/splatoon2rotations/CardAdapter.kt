package com.kyostudios.splatoon2rotations

import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kyostudios.splatoon2rotation.Rotation
import kotlinx.android.synthetic.main.card_rotation.view.*

class CardAdapter(private val myDataset: ArrayList<Rotation>): RecyclerView.Adapter<MyViewHolder>() {

    var data: ArrayList<Rotation> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_rotation, parent,false) as CardView
        return MyViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        data.add(myDataset[position])

        val rotationCard =
                RotationCard.newInstance(
                        myDataset[position].gameRule,
                        myDataset[position].mapAlpha.stageID,
                        myDataset[position].mapBeta.stageID,
                        myDataset[position].startTime,
                        myDataset[position].endTime,
                        myDataset[position].isCurrent,
                        myDataset[position].isSplatfest
                )

        holder.mapATitle.text = rotationCard.mapATitle
        holder.mapAImage.setImageResource(rotationCard.mapAImageID)
        holder.mapBTitle.text = rotationCard.mapBTitle
        holder.mapBImage.setImageResource(rotationCard.mapBImageID)
        holder.fromTime.text = rotationCard.startHour.toString()
        holder.toTime.text = rotationCard.endHour.toString()
        holder.title.text = rotationCard.gameRule
    }

    override fun getItemCount(): Int = data.size
}


class MyViewHolder(cardView: View): RecyclerView.ViewHolder(cardView) {
    val title: TextView = cardView.cardGameMode
    val fromTime: TextView = cardView.cardFromTimeText
    val toTime: TextView = cardView.cardToTimeText
    val mapATitle: TextView = cardView.mapAText
    val mapBTitle: TextView = cardView.mapBText
    val mapAImage: ImageView = cardView.mapAImage
    val mapBImage: ImageView = cardView.mapBImage
}
