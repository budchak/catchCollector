package com.yaroshevich.catchcollector.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.ui.adapter.BindingAdapter
import com.yaroshevich.catchcollector.ui.adapter.BindingProperty
import com.yaroshevich.catchcollector.ui.adapter.diff.CountryDiffUtilCallback
import com.yaroshevich.catchcollector.viewModels.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*


class SearchDialog : DialogFragment() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel = SearchViewModel(this)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        search_edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchViewModel.searchRequestText.postValue(s.toString())
            }

        })

        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        recycler_view.adapter = createAdapter()

        recycler_view.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
    }


    private fun createAdapter(): BindingAdapter {
        val adapter = BindingAdapter()

        adapter.lifecycleOwner = this

        adapter.holderBindingProperty[Country::class] =
            BindingProperty(BR.searchModel, R.layout.item_country_search)

        searchViewModel.liveCountry.observe(this, Observer {
            val countryDiffUtil = CountryDiffUtilCallback(adapter.items as List<Country>, it)
            val diffResult = DiffUtil.calculateDiff(countryDiffUtil)
            adapter.items = it.toMutableList()
            diffResult.dispatchUpdatesTo(adapter)
        })

        return adapter
    }


}