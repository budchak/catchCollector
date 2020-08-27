package com.yaroshevich.catchcollector.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData

class ToolbarSettingViewModel {

    var toolbarStatus = MutableLiveData<Int>(View.VISIBLE)

    var toolbarTitle = MutableLiveData<String>("Trophies")

    var backArrayVisibility = MutableLiveData<Boolean>(false)


}