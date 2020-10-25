package com.yaroshevich.catchcollector.utils

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_fish_preview.view.*

class GlideImageLoader(context: Context): ImageLoader(context) {

     fun load(view: View, path: String, imageView: ImageView) {
        Glide.with(view)
            .asBitmap()
            .load(parseUri(path))
            .into(imageView)
    }

    private fun parseUri(string: String) = Uri.parse(string)

    override fun load() {

    }
}