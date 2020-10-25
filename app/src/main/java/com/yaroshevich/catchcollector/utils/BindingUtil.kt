package com.yaroshevich.catchcollector.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("custom:scaleType")
fun ImageView.setParameter(boolean: Boolean) {
    when (boolean) {
        true -> {
            this.adjustViewBounds = true
            this.scaleType = ImageView.ScaleType.FIT_XY
        }
        false -> {
            this.adjustViewBounds = false
            this.scaleType = ImageView.ScaleType.FIT_CENTER
        }
    }

}
