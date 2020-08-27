package com.yaroshevich.catchcollector.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.R
import kotlinx.android.synthetic.main.item_trophy_info.view.*
import javax.inject.Inject

class TrophyFragment : Fragment() {

    @Inject
    lateinit var navController: NavController

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.getInstance().initTrophyComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_trophy_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        initView(view)
    }


    private fun initView(view: View) {
        view.apply {
            country_container.setOnClickListener {
                navController.navigate(R.id.searchDialog)
            }
        }
    }
}