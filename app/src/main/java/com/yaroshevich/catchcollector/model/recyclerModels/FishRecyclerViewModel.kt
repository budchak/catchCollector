package com.yaroshevich.catchcollector.model.recyclerModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.ui.adapter.FishAdapter


class FishRecyclerViewModel(
    var context: Context,
    data: LiveData<List<Fish>>,
    var itemClickListener: ItemClickListener
) : RecyclerViewModel() {

    private var liveFish = data

    override var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder> = createAdapter()

    override var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

    override var itemDecorator: RecyclerView.ItemDecoration =
        DividerItemDecoration(context, RecyclerView.VERTICAL)

    private fun createAdapter(): FishAdapter {

        val fishAdapter = FishAdapter()

        fishAdapter.itemClickListener = itemClickListener

        liveFish.observe((context as NavigationActivity), Observer {

            fishAdapter.fishes = it as MutableList<Fish>

            Toast.makeText(context, "${it.size}", Toast.LENGTH_LONG).show()

            fishAdapter.notifyDataSetChanged()

        })

        return fishAdapter
    }
}