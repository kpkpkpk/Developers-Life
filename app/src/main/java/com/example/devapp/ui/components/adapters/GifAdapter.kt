package com.example.devapp.ui.components.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.devapp.data.model.GifModel
import com.example.devapp.databinding.MemItemBinding

class GifAdapter() : ListAdapter<GifModel, GifAdapter.ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<GifModel>() {
        override fun areItemsTheSame(oldItem: GifModel, newItem: GifModel): Boolean {
            return oldItem.gifURL == newItem.gifURL
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: GifModel, newItem: GifModel): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(
        private val binding: MemItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context
        //GifsViewModel
        fun bind(cont) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MemItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}