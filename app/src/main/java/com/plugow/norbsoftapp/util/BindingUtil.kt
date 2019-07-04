package com.plugow.norbsoftapp.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.plugow.norbsoftapp.ui.adapter.BaseAdapter


@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setRecyclerData(recyclerView: RecyclerView, items: List<T>?) {
    if (recyclerView.adapter is BaseAdapter<*>) {
        items?.let {
            (recyclerView.adapter as BaseAdapter<T>).setData(it)
        }
    }
}

