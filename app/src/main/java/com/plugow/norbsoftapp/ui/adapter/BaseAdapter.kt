package com.plugow.norbsoftapp.ui.adapter
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected val values: ArrayList<T> = arrayListOf()

    fun setData(items:List<T>){
        values.clear()
        values.addAll(items)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return values.size
    }

}