package com.yaroshevich.catchcollector.utils

import android.content.Context
import android.provider.ContactsContract

class AssetImageLoader(context: Context): ImageLoader(context) {

    override fun load() {
        val assetManager = context.assets
    }
}