package com.yaroshevich.catchcollector.model.recyclerModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.TrophyPreview
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.BindingAdapter
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.BindingProperty
import com.yaroshevich.catchcollector.ui.recyclerview.itemDecorarion.GridLayoutDecorator
import com.yaroshevich.catchcollector.viewModels.ItemTrophyPreviewViewModel


class FishRecyclerViewModel(
    var context: Context,
    data: LiveData<List<ItemTrophyPreviewViewModel>>,
    var itemClickListener: ItemClickListener
) : RecyclerViewModel() {

    private var liveFish = data

    override var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder> = createAdapter()

    override var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)

    override var itemDecorator: RecyclerView.ItemDecoration = GridLayoutDecorator()

    private fun createAdapter(): BindingAdapter {

        val fishAdapter = BindingAdapter()

        fishAdapter.holderBindingProperty[ItemTrophyPreviewViewModel::class] =
            BindingProperty(BR.fishPreview, R.layout.item_fish_preview_card)

        fishAdapter.lifecycleOwner = context as LifecycleOwner


        liveFish.observe((context as NavigationActivity), Observer {

            fishAdapter.items = it.toMutableList()

            Toast.makeText(context, "${it.size}", Toast.LENGTH_LONG).show()

            fishAdapter.notifyDataSetChanged()

        })

        return fishAdapter
    }
}