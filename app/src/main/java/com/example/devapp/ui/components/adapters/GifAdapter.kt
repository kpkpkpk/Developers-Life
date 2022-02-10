package com.example.devapp.ui.components.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.devapp.domain.model.GifModel
import com.example.devapp.databinding.MemItemBinding

class GifAdapter() : PagingDataAdapter<GifModel, GifAdapter.ViewHolder>(DiffCallback()) {

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

        fun bind(gifModel: GifModel?) {
            with(binding){
                author.text = gifModel?.author
                postTitle.text = gifModel?.description
                date.text = gifModel?.date
                loadPreview(gifModel?.previewURL)
                gif.setOnClickListener {
                    loadGif(gifModel?.gifURL)
                }
            }
        }

        private fun loadPreview(url: String?) {
            Glide
                .with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.gif)
        }

        private fun loadGif(url:String?) {
            Glide.with(context)
                .asGif()
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.gif)
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
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}