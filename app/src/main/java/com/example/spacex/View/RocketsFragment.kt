package com.example.spacex.View

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.SpaceX.RocketsQuery
import com.example.spacex.Adapters.RocketsAdapter
import com.example.spacex.R
import com.example.spacex.ViewModel.RocketsVM
import com.example.spacex.databinding.RocketsBinding

class RocketsFragment : Fragment() {

    private lateinit var rocketsViewModel: RocketsVM
    private lateinit var binding: RocketsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RocketsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarRockets.visibility = View.VISIBLE
        binding.recViewRockets.visibility = View.GONE
        binding.recViewRockets.layoutManager = LinearLayoutManager(requireContext())

        rocketsViewModel = ViewModelProvider(this).get(RocketsVM::class.java)
        rocketsViewModel.getRockets()
        rocketsViewModel.rocketsList.observe(viewLifecycleOwner, {
            val adapter = RocketsAdapter(it as MutableList<RocketsQuery.Launch>)
            binding.recViewRockets.adapter = adapter
            binding.recViewRockets.visibility = View.VISIBLE
            binding.progressBarRockets.visibility = View.GONE
        })

    }
}
