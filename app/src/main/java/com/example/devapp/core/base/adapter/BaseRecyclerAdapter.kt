package com.example.devapp.core.base.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pewpee.core.adapter.BaseViewHolder

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>>(list: List<T>) :
    ListAdapter<T,VH>() {
    private var _recyclerView: RecyclerView? = null

    var items: MutableList<T> = list.toMutableList()

    val isEmpty
        get() = itemCount == 0

    protected fun scrollTop() {
        _recyclerView?.scrollToPosition(0)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        _recyclerView = recyclerView
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    fun getItem(position: Int) = items[position]

    fun setItem(position: Int, item: T) {
        items[position] = item
    }

}