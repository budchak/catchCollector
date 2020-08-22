package com.yaroshevich.catchcollector.ui.itemDecorarion

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridLayoutDecorator: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(20,20,20,20)
    }
}