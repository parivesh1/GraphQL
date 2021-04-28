package com.example.spacex.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.api.load
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.MissionListQuery
import com.example.spacex.R
import com.example.spacex.databinding.MissionsItemBinding

class MissionsAdapter(val missions: MutableList<MissionListQuery.Launch>) :
    RecyclerView.Adapter<MissionsAdapter.ViewHolder>() {

    class ViewHolder(val binding: MissionsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return missions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MissionsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mission = missions[position]
        holder.binding.missionName.text = mission.mission?.name
        holder.binding.imageView2.load(mission.mission?.missionPatch) {
            placeholder(R.drawable.ic_placeholder)
        }
    }
}