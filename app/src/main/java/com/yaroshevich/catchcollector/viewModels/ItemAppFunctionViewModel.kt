package com.yaroshevich.catchcollector.viewModels

import android.view.View
import android.widget.Toast
import com.yaroshevich.catchcollector.model.Function

class ItemAppFunctionViewModel(val function: Function, val viewModel: AppFunctionViewModel) : View.OnClickListener {

    override fun onClick(v: View?) {
        viewModel.onItemClick(function.name)
    }
}