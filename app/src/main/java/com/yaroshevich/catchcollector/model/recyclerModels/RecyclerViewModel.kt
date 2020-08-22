package com.yaroshevich.catchcollector.model.recyclerModels

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewModel {

    abstract var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>
    abstract var layoutManager: RecyclerView.LayoutManager

    abstract var itemDecorator:  RecyclerView.ItemDecoration

    companion object{
        @JvmStatic
        @BindingAdapter("custom:adapter")
        fun crateAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
            recyclerView.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("custom:decorator")
        fun addDecoration(recyclerView: RecyclerView, decorator: RecyclerView.ItemDecoration){
            recyclerView.addItemDecoration(decorator)
        }

    }

}