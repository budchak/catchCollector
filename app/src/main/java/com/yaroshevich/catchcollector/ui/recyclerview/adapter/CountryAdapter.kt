package com.yaroshevich.catchcollector.ui.recyclerview.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Country
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    var countries = mutableListOf<Country>()

    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position], itemClickListener)
    }
}


class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(country: Country, listener: ItemClickListener? = null) {
        itemView.apply {
            country_name.text = country.name

            val pathUri = "file:///android_asset${country.iconPath}"
            Glide.with(this)
                .asBitmap()
                .load(Uri.parse(pathUri))
                .into(fish_icon)

            click_listener_container.setOnClickListener {
                listener?.onClick(country.id)
            }
        }
    }

}