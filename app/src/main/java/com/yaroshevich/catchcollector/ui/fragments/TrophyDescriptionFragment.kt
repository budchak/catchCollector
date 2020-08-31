package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.R

class TrophyDescriptionFragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trophy_description, container, false)
    }


    override fun onResume() {
        super.onResume()

        (activity as NavigationActivity).changeToolbarVisibility(View.GONE)
    }
}