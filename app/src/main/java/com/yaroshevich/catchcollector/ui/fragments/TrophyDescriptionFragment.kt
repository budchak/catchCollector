package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.model.TrophyPreview
import com.yaroshevich.catchcollector.ui.recyclerview.adapter.FishAdapter
import kotlinx.android.synthetic.main.fragment_trophy_description.*

class TrophyDescriptionFragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trophy_description, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = FishAdapter()
        adapter.fishes.apply {
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","/images/fish/grass_carp.png"))
            add(TrophyPreview(1,1,"Sdf","sdfsd"))
            add(TrophyPreview(1,1,"Sdf","sdfsd"))
            add(TrophyPreview(1,1,"Sdf","sdfsd"))
            add(TrophyPreview(1,1,"Sdf","sdfsd"))
            add(TrophyPreview(1,1,"Sdf","sdfsd"))
        }
        recycler_view.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        (activity as NavigationActivity).changeToolbarVisibility(View.GONE)
    }
}