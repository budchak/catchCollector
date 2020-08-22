package com.yaroshevich.catchcollector

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class NavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getInstance().initNavigationActivityComponent(this).inject(this)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        initToolbar(toolbar, "My Trophies")

    }

    fun initToolbar(toolbar: Toolbar, title: String) {
        attachToolbar(toolbar)
        setToolbarTitle(title)
    }

    private fun attachToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
    }

    private fun setToolbarTitle(title: String) {
        toolbar_title.text = title
    }


}
