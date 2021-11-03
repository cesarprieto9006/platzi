package com.example.projectlist.screens.main.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectlist.databinding.ItemDataBinding
import com.example.projectlist.screens.main.model.DataFish
import com.example.projectlist.utils.setSingleClickListener
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class FishAdapter(val onItemClick: ((data: DataFish) -> Unit)? = null) :
    RecyclerView.Adapter<FishAdapter.HistoryViewHolder>() {

    private var listData = ArrayList<DataFish>()
    private var filterPersonalData: ArrayList<DataFish> = listData
    private lateinit var context: Context

    fun addAll(collection: Collection<DataFish>) {
        listData.clear()
        notifyDataSetChanged()
        for (data in collection) {
            listData.add(data)
            notifyItemInserted(listData.size)
        }
    }

    fun contextViewAdapter(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(inflater, parent, false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount() = filterPersonalData.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val itemRoute = filterPersonalData[position]
        holder.bind(itemRoute)
    }


    inner class HistoryViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataFish: DataFish) {
            binding.tvName.text =
                Html.fromHtml(dataFish.scientificName ?: "").toString().replace("\n", "").trim()
            binding.tvNumberId.text =
                Html.fromHtml(dataFish.specieName ?: "").toString().replace("\n", "").trim()
            binding.tvAddress.text =
                Html.fromHtml(dataFish.texture ?: "").toString().replace("\n", "").trim()
            binding.tvPhone.text =
                Html.fromHtml(dataFish.servingWeight ?: "").toString().replace("\n", "").trim()

            binding.ivFish.visibility = if (dataFish.imageList.src != "")
                View.VISIBLE else View.GONE

            Glide.with(context)
                .load(dataFish.imageList.src)
                .into(binding.ivFish)

            binding.tvMore.setSingleClickListener {
                onItemClick?.invoke(dataFish)
            }


        }
    }
}