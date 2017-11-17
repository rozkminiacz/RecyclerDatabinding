package com.rozkmin.recyclerdatabindingshowcase

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rozkmin.recyclerdatabindingshowcase.databinding.ItemBinding

/**
 * Created by jmichalik on 17.11.17
 */
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var items = listOf<ItemViewModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder =
            ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false))

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(private val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemViewModel: ItemViewModel) {
            itemBinding.item = itemViewModel
            itemBinding.executePendingBindings()
        }
    }
}