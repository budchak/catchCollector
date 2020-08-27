package com.yaroshevich.catchcollector

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.yaroshevich.catchcollector.viewModels.ToolbarSettingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NavigationActivity : AppCompatActivity() {

    @Inject
    lateinit var toolbarSettingViewModel: ToolbarSettingViewModel





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getInstance().initNavigationActivityComponent(this).inject(this)


        initToolbar(toolbar, "My Trophies", true)


        toolbarSettingViewModel.toolbarTitle.observe(this, Observer {
            when(it){
                null -> Log.e(this.localClassName, "пустая строка")
                else ->  setToolbarTitle(it)
            }

        })

    }

    fun initToolbar(toolbar: Toolbar, title: String, transparentStatusBar: Boolean) {

        attachToolbar(toolbar)

        setToolbarTitle(title)

        setTransparentStatusBar(transparentStatusBar)

    }

    private fun attachToolbar(toolbar: Toolbar) {

        setSupportActionBar(toolbar)

        supportActionBar?.title = ""

    }

     fun setToolbarTitle(title: String) {

       toolbar_title.text = title

    }


    private fun setTransparentStatusBar(transparentStatusBar: Boolean) {

        if (transparentStatusBar) window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

    }
}
