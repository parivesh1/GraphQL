package com.example.spacex.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.MissionListQuery
import com.example.spacex.Adapters.MissionsAdapter
import com.example.spacex.R
import com.example.spacex.ViewModel.MissionsVM
import com.example.spacex.databinding.LaunchesBinding
import com.example.spacex.databinding.MissionsBinding

class MissionsFragment : Fragment() {

    private lateinit var missionViewModel: MissionsVM
    private lateinit var binding: MissionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MissionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recViewMissions.visibility = View.GONE
        binding.progressBarMissions.visibility = View.VISIBLE
        binding.recViewMissions.layoutManager = LinearLayoutManager(requireContext())

        missionViewModel = ViewModelProvider(this).get(MissionsVM::class.java)
        missionViewModel.getMissions()
        missionViewModel.missionList.observe(viewLifecycleOwner, {
            val adapter = MissionsAdapter(it as MutableList<MissionListQuery.Launch>)
            binding.recViewMissions.adapter = adapter
            binding.progressBarMissions.visibility = View.GONE
            binding.recViewMissions.visibility = View.VISIBLE
        })

    }
}
