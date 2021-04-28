package com.example.spacex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.LaunchListQuery
import com.example.spacex.R

class LaunchesAdapter(val launches: MutableList<LaunchListQuery.Launch>) : RecyclerView.Adapter<LaunchesAdapter.LaunchpadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchpadViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.launches_item,
            parent, false)
        return LaunchpadViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LaunchpadViewHolder, position: Int) {

        val currentItem = launches[position]

        holder.launchID.text = currentItem.id
        holder.launchSite.text = currentItem.site ?: ""
    }

    override fun getItemCount() = launches.size

    class LaunchpadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val launchID: TextView = itemView.findViewById(R.id.launchId)
        val launchSite: TextView = itemView.findViewById(R.id.launchSite)

    }
}