package com.example.spacex.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.LaunchListQuery
import com.example.spacex.Adapters.LaunchesAdapter
import com.example.spacex.LaunchVM
import com.example.spacex.R
import com.example.spacex.databinding.LaunchesBinding

class LaunchesFragment : Fragment() {

    private lateinit var launchViewModel: LaunchVM
    private lateinit var binding: LaunchesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LaunchesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recViewLaunches.visibility = View.GONE
        binding.progressBarLaunch.visibility = View.VISIBLE


        binding.recViewLaunches.layoutManager = LinearLayoutManager(requireContext())

        launchViewModel = ViewModelProvider(this).get(LaunchVM::class.java)
        launchViewModel.getLaunches()
        launchViewModel.launchList.observe(viewLifecycleOwner, {
            val adapter = LaunchesAdapter(it as MutableList<LaunchListQuery.Launch>)
            binding.progressBarLaunch.visibility = View.GONE
            binding.recViewLaunches.visibility = View.VISIBLE
            binding.recViewLaunches.adapter = adapter
        })

    }
}
