package com.yaroshevich.catchcollector.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

class BindingAdapter: RecyclerView.Adapter<BindingViewHolder>() {

    val holderBindingProperty = mutableMapOf<KClass<out Any>, BindingProperty>()

    var items = mutableListOf<Any>()

    lateinit var lifecycleOwner: LifecycleOwner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BindingViewHolder(
            layoutInflater.inflate(
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return  items.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        val bindingProperty = holderBindingProperty[item::class]

        return bindingProperty?.layoutId ?: -2

    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {

        val bindingProperty = holderBindingProperty[items[position]::class]

        if (bindingProperty != null){
            holder.binding?.setVariable(bindingProperty.bindingId, items[position])
            holder.binding?.lifecycleOwner = lifecycleOwner
        }



    }
}

open class BindingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = DataBindingUtil.bind<ViewDataBinding>(view)

}


class BindingProperty(val bindingId: Int, val layoutId: Int)