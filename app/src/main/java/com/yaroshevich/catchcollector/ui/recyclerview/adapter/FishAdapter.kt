package com.yaroshevich.catchcollector.ui.recyclerview.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.TrophyPreview
import com.yaroshevich.catchcollector.utils.AssetDirectory
import kotlinx.android.synthetic.main.item_fish_preview.view.*

class FishAdapter : RecyclerView.Adapter<FishViewHolder>() {

    var fishes = mutableListOf<TrophyPreview>()

    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_fish_preview, parent, false)
        return FishViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fishes.size
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        holder.bind(fishes[position], itemClickListener)
    }
}


class FishViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fish: TrophyPreview, listener: ItemClickListener? = null) {
        itemView.apply {
            fish_name_text_view.text = fish.name
            if (fish.bestTrophy != null){
                is_catch_text_view.text = fish.bestTrophy!!.length.toString()
            }

            val pathUri = "${AssetDirectory.getPath()}${fish.previewImage}"
            Log.e("nfrs", pathUri)
            Glide.with(this)
                .asBitmap()
                .load(Uri.parse(pathUri))
                .into(imageView)

            container.setOnClickListener {
                listener?.onClick(fish.fishId)
            }
        }
    }

}