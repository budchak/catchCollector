package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.BindingAdapter
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.BindingProperty
import com.yaroshevich.catchcollector.viewModels.AppFunctionViewModel
import com.yaroshevich.catchcollector.viewModels.ItemAppFunctionViewModel
import kotlinx.android.synthetic.main.fragment_app_function.*
import javax.inject.Inject

class AppFunctionFragment : Fragment() {

    @Inject
    lateinit var appFunctionViewModel: AppFunctionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        App.getInstance().initAppFunctionComponent().inject(this)

        return inflater.inflate(R.layout.fragment_app_function, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val appFunctionAdapter = BindingAdapter()

        appFunctionAdapter.holderBindingProperty[ItemAppFunctionViewModel::class] =
            BindingProperty(BR.viewModel, R.layout.item_app_function)

        appFunctionAdapter.lifecycleOwner = this

        appFunctionViewModel.appFunctions.observe(viewLifecycleOwner, Observer { it ->

            val items = mutableListOf<ItemAppFunctionViewModel>()

            it.forEach {
                items.add(ItemAppFunctionViewModel(it, appFunctionViewModel))
            }

            appFunctionAdapter.items = items.toMutableList()

            appFunctionAdapter.notifyDataSetChanged()
        })

        recycler_view.apply {

            layoutManager = LinearLayoutManager(context)

            adapter = appFunctionAdapter

            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))

        }


    }


}