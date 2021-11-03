package com.example.projectlist.screens.main.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectlist.R
import com.example.projectlist.databinding.FragmentListBinding
import com.example.projectlist.screens.main.adapter.FishAdapter
import com.example.projectlist.screens.main.model.DataFish
import com.example.projectlist.screens.main.viewmodel.MainViewModel
import com.example.projectlist.utils.Utils


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val fishAdapter = FishAdapter(::moreClicked)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData()

        viewModel.isError.value = !Utils().isConnected(requireActivity())


        setupListener()
        observerLiveData()
    }

    private fun setupListener() {

        binding.rvFish.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = fishAdapter
        }
        fishAdapter.contextViewAdapter(requireActivity())

    }

    private fun observerLiveData() {
        viewModel.dataData.observe(viewLifecycleOwner, Observer { list ->
            fishAdapter.addAll(list)
        })
    }

    private fun moreClicked(dataFish: DataFish) {
        viewModel.dataFish = dataFish
    }
}