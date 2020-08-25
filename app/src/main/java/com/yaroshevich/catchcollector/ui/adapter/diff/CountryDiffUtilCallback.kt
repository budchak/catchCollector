package com.yaroshevich.catchcollector.ui.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.yaroshevich.catchcollector.model.Country

class CountryDiffUtilCallback(var oldList: List<Country>, var newList: List<Country>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCountry = oldList[oldItemPosition]
        val newCountry = newList[newItemPosition]

        return oldCountry.id == newCountry.id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCountry = oldList[oldItemPosition]
        val newCountry = newList[newItemPosition]

        return oldCountry == newCountry
    }
}