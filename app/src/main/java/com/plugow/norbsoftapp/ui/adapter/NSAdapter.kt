package com.plugow.norbsoftapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plugow.norbsoftapp.R
import com.plugow.norbsoftapp.data.local.NSItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ns_item.*
import javax.inject.Inject

class NSAdapter @Inject constructor(private val picasso: Picasso) : BaseAdapter<NSItem>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<NSItem> {
        return NSViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ns_item, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<NSItem>, position: Int) {
        val nsItem = values[position]
        holder.bind(nsItem, picasso)

    }


    class NSViewHolder(containerView: View) : BaseViewHolder<NSItem>(containerView) {
        override fun bind(item: NSItem, picasso: Picasso) {
            title.text = item.title
            description.text = item.description
            picasso.load(item.imageUrl).into(thumb)
        }
    }
}