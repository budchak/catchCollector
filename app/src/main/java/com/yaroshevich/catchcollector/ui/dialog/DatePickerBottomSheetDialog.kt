package com.yaroshevich.catchcollector.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yaroshevich.catchcollector.R


class DatePickerBottomSheetDialog : DialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog =
            Dialog(requireActivity(), R.style.CustomDatePickerDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // must be called before set content

        dialog.setContentView(R.layout.dialog_date_picker)
        dialog.setCanceledOnTouchOutside(true)


        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.BOTTOM
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT
        window.attributes = wlp

        return dialog
    }

}