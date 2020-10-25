package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.yaroshevich.catchcollector.R

open class RecyclerViewFragment : Fragment() {

    lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_recycler_view_binding, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}