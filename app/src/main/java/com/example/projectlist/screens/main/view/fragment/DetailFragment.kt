package com.example.projectlist.screens.main.view.fragment

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.projectlist.R
import com.example.projectlist.databinding.FragmentDetailBinding
import com.example.projectlist.screens.main.viewmodel.MainViewModel


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData(){
        Glide.with(requireActivity())
            .load(viewModel.dataFish.imageList.src)
            .into(binding.ivFish)

        binding.tvName.text = viewModel.dataFish.scientificName
        binding.tvBiology.text =
            Html.fromHtml(viewModel.dataFish.biology ?: "").toString().replace("\n", "").trim()
        binding.tvHabitatDescription.text =
            Html.fromHtml(viewModel.dataFish.habitat ?: "").toString().replace("\n", "").trim()
        binding.tvHarvestDescription.text =
            Html.fromHtml(viewModel.dataFish.harvest ?: "").toString().replace("\n", "").trim()
        binding.tvLocationDescription.text =
            Html.fromHtml(viewModel.dataFish.location ?: "").toString().replace("\n", "").trim()
        binding.tvFishingDescription.text =
            Html.fromHtml(viewModel.dataFish.fishingRate ?: "").toString().replace("\n", "").trim()

        binding.ivFish.animate().apply {
            duration=5000
            rotationYBy(360f)
        }.withEndAction {
            binding.ivFish.animate().apply {
                duration = 5000
                rotationXBy(3600f)
            }
        }
    }
}