package com.yaroshevich.catchcollector.ui.recyclerview.adapter.binding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yaroshevich.catchcollector.utils.AssetDirectory

class ImageLoaderAdapter {

    companion object{

        @JvmStatic
        @BindingAdapter("custom:image")
        fun load(imageView: ImageView, path: String) {

            val pathUri = "${AssetDirectory.getPath()}$path"

            Log.e("ImageBinding", "image path: $pathUri")

            Glide.with(imageView.context)
                .load(pathUri)
                .into(imageView)

        }
    }
}