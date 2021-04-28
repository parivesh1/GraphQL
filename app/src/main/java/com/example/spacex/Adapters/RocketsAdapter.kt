package com.example.spacex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.RocketsQuery
import com.example.spacex.R

class RocketsAdapter(val rockets: MutableList<RocketsQuery.Launch>) : RecyclerView.Adapter<RocketsAdapter.RocketsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rockets_item,
            parent, false)
        return RocketsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RocketsViewHolder, position: Int) {

        val currentItem = rockets[position]

        holder.rocketID.text = currentItem.rocket?.id ?: ""
        holder.rocketName.text = currentItem.rocket?.name ?: ""
        holder.rocketType.text = currentItem.rocket?.type ?: ""
    }

    override fun getItemCount() = rockets.size

    class RocketsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rocketID: TextView = itemView.findViewById(R.id.rocketID)
        val rocketName: TextView = itemView.findViewById(R.id.rocketName)
        val rocketType: TextView = itemView.findViewById(R.id.rocketType)

    }
}