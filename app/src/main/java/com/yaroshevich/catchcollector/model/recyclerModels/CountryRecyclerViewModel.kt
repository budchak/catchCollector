package com.yaroshevich.catchcollector.model.recyclerModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.repository.CountryRepository
import com.yaroshevich.catchcollector.ui.adapter.CountryAdapter
import com.yaroshevich.catchcollector.ui.itemDecorarion.GridLayoutDecorator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CountryRecyclerViewModel(var context: Context, var itemClickListener: ItemClickListener) : RecyclerViewModel() {

    private var liveCountry = MutableLiveData<List<Country>>()


    override var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder> = createAdapter()

    override var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)

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