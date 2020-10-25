package com.yaroshevich.catchcollector.model.recyclerModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.model.repository.CountryRepository
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.CountryAdapter
import com.yaroshevich.catchcollector.ui.recyclerview.itemDecorarion.GridLayoutDecorator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CountryRecyclerViewModel(var context: Context, var itemClickListener: ItemClickListener) : RecyclerViewModel() {

    private var liveCountry = MutableLiveData<List<Country>>()

    private val spanCount = 3

    override var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder> = createAdapter()

    override var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, spanCount, RecyclerView.VERTICAL, false)

    override var itemDecorator: RecyclerView.ItemDecoration = GridLayoutDecorator()



    fun createAdapter(): CountryAdapter {

        val countryAdapter = CountryAdapter()

        GlobalScope.launch {

            liveCountry.postValue(CountryRepository().getAll() as MutableList<Country>)

        }
        liveCountry.observe((context as NavigationActivity), Observer {

            countryAdapter.countries = it as MutableList<Country>

            Toast.makeText(context, "${it.size}", Toast.LENGTH_LONG).show()

            countryAdapter.notifyDataSetChanged()

        })

        countryAdapter.itemClickListener = itemClickListener

        return countryAdapter
    }
}